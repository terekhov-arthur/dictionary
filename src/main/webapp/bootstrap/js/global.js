var definitionIndex = 0;
var timer;
var $search;

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
                $.get('/translate?value='+ ui.item.value, function(data) {
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
    var $word = $('#word');
    var $definition = $('#definition');
    var $transcription = $('#transcription');
    var $video = $('#video');

    $word.text(data.word);
    $transcription.text(data.transcription);

//todo: localization mb
    var htmlData = '';
    var pos = null;
    var pos_counter = 1;
    var single_pos_counter = 1;

    data.translations.forEach(function (item) {
        if(pos !== item.value) {
            pos = item.value;
            single_pos_counter = 1;
            htmlData = htmlData.concat('<div class="row pos_row">').concat(pos_counter++).concat('. ').concat(pos).concat('</div>');
        }
        htmlData = htmlData.concat('<div class="row margin-left-5 font-size-18 trans_row">').concat(single_pos_counter++).concat(') ').concat(item.key).concat('</div>');
    });

    $data.html(htmlData);
    $definition.text(data.definition);
    $video.html('<video width="720" height="480" controls><source src="/video/'.concat(data.videoPath).concat('" type="video/mp4"></video>'));
}