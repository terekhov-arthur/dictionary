$(document).ready(function () {
    var table = $("#definitionList");
    $("#add-definition").click(function () {

        var value = $('#definition').val();
        var part = $('#partOfSpeech').val();

        table.append('<tr>' +
                        '<td>'+ value + '<input type="hidden" name="definitionList" value="'+ value +'"/></td>' +
                        '<td>'+ part +'<input type="hidden" name="partOfSpeechList" value="'+ part +'"/></td>' +
                        '<td><input type="button" id="delete" class="btn btn-link" value="delete" onclick="del()"></td>' +
                     '</tr>');
    });
});

function del() {

}