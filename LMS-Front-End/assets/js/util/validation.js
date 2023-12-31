$("#name").focus();

const NameRegEx =  /^[A-z ]{5,20}$/;
const EmailRegEx = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
const PasswordRegEx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;

let updateStudent = [];
updateStudent.push({reg: NameRegEx, field: $('#name'),error:'Name Pattern is Wrong : A-z 5-20'});
updateStudent.push({reg: EmailRegEx, field: $('#email'),error:'Email Pattern is Wrong : A-z @ 1-9 gmail.com'});
updateStudent.push({reg: PasswordRegEx, field: $('#password'),error:'Password Pattern is Wrong : A-Z a-z symbols 1-9'});


//disable tab key of all four text fields using grouping selector in CSS
$("#name,#email,#password").on('keydown', function (event) {
    if (event.key == "Tab") {
        event.preventDefault();
    }
});


$("#name,#email,#password").on('keyup', function (event) {
    checkValidity();
});

$("#name,#email,#password").on('blur', function (event) {
    checkValidity();
});


$("#name").on('keydown', function (event) {
    if (event.key == "Enter" && check(NameRegEx, $("#name"))) {
        $("#email").focus();
    } else {
        focusText($("#name"));
    }
});


$("#email").on('keydown', function (event) {
    if (event.key == "Enter" && check(EmailRegEx, $("#email"))) {
        focusText($("#password"));
    }
});


$("#password").on('keydown', function (event) {
    if (event.key == "Enter" && check(PasswordRegEx, $("#price"))) {
        focusText($("#updateInfo"));
    }
});


function checkValidity() {
    let errorCount=0;
    for (let validation of updateStudent) {
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
        $("#updateInfo").attr('disabled',true);
    }else{
        $("#updateInfo").attr('disabled',false);
    }
}
