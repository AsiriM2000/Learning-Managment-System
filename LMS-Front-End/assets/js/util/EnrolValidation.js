$("#name").focus();

const NameRegEx =  /^[A-z ]{5,20}$/;
const AddressRegEx =  /^[0-9/A-z. ,]{7,}$/;
const ContactRegEx =  /^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$/;
const EmailRegEx = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const NICRegEx = /^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$/;


let enrollCourse = [];
enrollCourse.push({reg: NameRegEx, field: $('#name'),error:'Name Pattern is Wrong : A-z 5-20'});
enrollCourse.push({reg: AddressRegEx, field: $('#address'),error:'Address Pattern is Wrong : A-z 0-9 ,/'});
enrollCourse.push({reg: ContactRegEx, field: $('#contact'),error:'Contact Pattern is Wrong : 0-9'});
enrollCourse.push({reg: EmailRegEx, field: $('#email'),error:'Email Pattern is Wrong : A-z @ 1-9 gmail.com'});
enrollCourse.push({reg: NICRegEx, field: $('#nic'),error:'Nic Pattern is Wrong : 0-9,A-z'});



//disable tab key of all four text fields using grouping selector in CSS
$("#name,#address,#contact,#email,#nic").on('keydown', function (event) {
    if (event.key == "Tab") {
        event.preventDefault();
    }
});


$("#name,#address,#contact,#email,#nic").on('keyup', function (event) {
    checkValidity();
});

$("#name,#address,#contact,#email,#nic").on('blur', function (event) {
    checkValidity();
});


$("#name").on('keydown', function (event) {
    if (event.key == "Enter" && check(NameRegEx, $("#name"))) {
        $("#address").focus();
    } else {
        focusText($("#name"));
    }
});


$("#address").on('keydown', function (event) {
    if (event.key == "Enter" && check(AddressRegEx, $("#address"))) {
        focusText($("#contact"));
    }
});


$("#contact").on('keydown', function (event) {
    if (event.key == "Enter" && check(ContactRegEx, $("#contact"))) {
        focusText($("#email"));
    }
});

$("#email").on('keydown', function (event) {
    if (event.key == "Enter" && check(EmailRegEx, $("#email"))) {
        focusText($("#nic"));
    }
});

$("#nic").on('keydown', function (event) {
    if (event.key == "Enter" && check(NICRegEx, $("#nic"))) {
        focusText($("#submitForm"))
    }
});


function checkValidity() {
    let errorCount=0;
    for (let validation of enrollCourse) {
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
        $("#submitForm").attr('disabled',true);
    }else{
        $("#submitForm").attr('disabled',false);
    }
}
