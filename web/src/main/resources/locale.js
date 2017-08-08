var i18n= {
    //#express.welcome
};

function locale(code, args) {
    if(typeof args == 'undefined' || !args) {
        return i18n[code];
    }


    if (!(args instanceof Array)) {
        args = [args];
    }
    var format = i18n[code];
    return format.replace(/\{(\d{1,})\}/g, function(a, b) {
        return args[b];
    });
}