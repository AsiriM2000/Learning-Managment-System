$("#name").focus();

// customer reguler expressions
const name = /^[A-z ]{5,20}$/;
const category = /^[A-z ]{5,20}$/;
const author = /^[A-z ]{5,20}$/;
const price = /^\d{1,3}(?:[.,]\d{3})*(?:[.,]\d{2})$/;
const qty = /^[1-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]$/;

let addBook = [];
addBook.push({reg: name, field: $('#name'),error:'Book Name Pattern is Wrong : A-z 5-20'});
addBook.push({reg: category, field: $('#category'),error:'Book Category Pattern is Wrong : A-z 5-20'});
addBook.push({reg: price, field: $('#price'),error:'Book Price Pattern is Wrong : 100.00'});
addBook.push({reg: author, field: $('#author'),error:'Book Author Pattern is Wrong : A-z 5-20'});
addBook.push({reg: qty, field: $('#qty'),error:'Book Price Pattern is Wrong : 1-9999'});


//disable tab key of all four text fields using grouping selector in CSS
$("#name,#category,#price,#author,#qty").on('keydown', function (event) {
    if (event.key == "Tab") {
        event.preventDefault();
    }
});


$("#name,#category,#price,#author,#qty").on('keyup', function (event) {
    checkValidity();
});

$("#name,#category,#price,#author,#qty").on('blur', function (event) {
    checkValidity();
});


$("#name").on('keydown', function (event) {
    if (event.key == "Enter" && check(name, $("#name"))) {
        $("#category").focus();
    } else {
        focusText($("#name"));
    }
});


$("#category").on('keydown', function (event) {
    if (event.key == "Enter" && check(category, $("#category"))) {
        focusText($("#price"));
    }
});


$("#price").on('keydown', function (event) {
    if (event.key == "Enter" && check(price, $("#price"))) {
        focusText($("#author"));
    }
});

$("#author").on('keydown', function (event) {
    if (event.key == "Enter" && check(author, $("#author"))) {
        focusText($("#qty"));
    }
});

$("#qty").on('keydown', function (event) {
    if (event.key == "Enter" && check(qty, $("#qty"))) {
        focusText($("#addBook"))
    }
});


function checkValidity() {
    let errorCount=0;
    for (let validation of addBook) {
        if (check(validation.reg,validation.field)) {
            textSuccess(validation.field,"");
        } else {
            errorCount=errorCount+1;
            setTextError(validation.field,validation.error);
        }
    }
    setButtonState(errorCount);
}

function check(regex, txtField) {
    let inputValue = txtField.val();
    return regex.test(inputValue) ? true : false;
}

function setTextError(txtField,error) {
    if (txtField.val().length <= 0) {
        defaultText(txtField,"");
    } else {
        txtField.css('border', '2px solid red');
        txtField.parent().children('span').text(error);
    }
}

function textSuccess(txtField,error) {
    if (txtField.val().length <= 0) {
        defaultText(txtField,"");
    } else {
        txtField.css('border', '2px solid green');
        txtField.parent().children('span').text(error);
    }
}

function defaultText(txtField,error) {
    txtField.css("border", "1px solid #ced4da");
    txtField.parent().children('span').text(error);
}

function focusText(txtField) {
    txtField.focus();
}

function setButtonState(value){
    if (value>0){
        $("#addBook").attr('disabled',true);
    }else{
        $("#addBook").attr('disabled',false);
    }
}

// function clearAllTexts() {
//     $("#name").focus();
//     $("#name,#category,#price,#author,#qty").val("");
//     checkValidity();
// }