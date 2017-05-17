$(document).ready(function () {
    var table = $("#definitionList");
    $("#add-definition").click(function () {

        var value = $('#definition').val();
        var part = $('#partOfSpeech').val();

        table.append('<br><input type="text" class="defs" readonly name="definitionList" value="'+ value +'"/>');
        table.append(' <input type="text" class="defs" name="partOfSpeechList" value="'+ part +'"/>');
    })
});