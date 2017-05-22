var definitionIndex = 0;
var timer;
var $search;
const doneTypingInterval = 1000;

$(document).ready(function () {
    $search = $('#search');
    var table = $("#definitionList");
    $("#add-definition").click(function () {

        var definition = $('#definition');
        var value = definition.val().trim();

        if(value === '') {
            return;
        }

        definition.val('');

        var part = $('#partOfSpeech').val();
        var id = 'def_'+definitionIndex++;

        //todo: maybe rename def to trans
        table.append('<tr id="'+id+'" >' +
                        '<td>'+ value + '<input type="hidden" name="definitionList" value="'+ value +'"/></td>' +
                        '<td>'+ part +'<input type="hidden" name="partOfSpeechList" value="'+ part +'"/></td>' +
                        '<td><input type="button" id="delete" class="btn btn-link" value="delete" onclick="del('+id+')"></td>' +
                     '</tr>');
    });

    $search.autocomplete({
        source: "/lookup",
        minLength: 2,
        select: function( event, ui ) {
                $.get('/translation/'+ ui.item.value, function(data) {
                renderData(data);
            });
        }
    });

});

function del(id) {
    $(id).remove();
}

function renderData(data) {
    var $data = $('#data');

    //todo: format func for a translation
    var htmlData = '<table>'
                    + '<tr><th colspan="3">'+ data.word +'</th></tr>'
                    + '<tr><th>Translation</th><th>Part Of Speech</th></tr>';

    data.translations.forEach(function (item) {
        htmlData += '<tr><td>' + item.key + ' ' + item.value  + '</td></tr>';
    });

    htmlData += '</table>';

    $data.html(htmlData);
}