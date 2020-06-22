$(function () {
    $('#example2').DataTable({
        'paging'      : true,
        'lengthChange': false,
        'searching'   : false,
        'ordering'    : true,
        'info'        : true,
        'autoWidth'   : false,
    // })



        "processing": true,
        // "searching": true,
        // "serverSide": true,
        "ajax": {
            "url": "/student/pageList",
        },

        /**
         private String admissionNumber;
         private String studentId;
         private String examRound;
         private String proposedMajor;
         private String identityNumber;

         private String birthdate;
         private String  registrationDate;
         private String  phone;
         private String  address;
         private String postecode;

         {"data": "identityNumber"},
         {"data": "birthdate"},
         {"data": "registrationDate"},
         {"data": "phone"},
         *
         */
        "columns": [
            {"data": "admissionNumber"},
            {"data": "studentId"},
            {"data": "examRound"},
            {"data": "proposedMajor"},

            {"data": "postecode"}
        ]
    })
})