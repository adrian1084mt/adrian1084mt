function traerInformacion() {
    var settings = {
        "url": "https://g351c9e52078320-adrian1084.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/skate/skate",
        "method": "GET",
        "timeout": 0,
        "headers": {
            "Access-Control-Allow-Origin": "*"
        }
    };

    $.ajax(settings).done(function (response) {
        console.log(response);
    });
}