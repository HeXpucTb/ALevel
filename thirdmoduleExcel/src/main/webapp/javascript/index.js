let currentTableName;
let iter = 2;
let symbol = 66;
let tempResList;
//Editing table Logic for buttons
$('#btnAddColumn').click(function () {
    let letter = String.fromCharCode(symbol);
    $('#tableForm').find('tr').each(function () {
        if($(this).attr('id') ==='tr0'){
            $(this).append('<th>'+letter+'</th>');
        } else {
            let num = $(this).attr('id').slice(2);
            $(this).append('<td>\n' +
                '<label>\n' +
                '<input type="text" id="'+letter+num+'" placeholder="Value" value="">\n' +
                '</label>\n' +
                '</td>')
        }
    });
    symbol++;
});
$('#btnDeleteCol').click(function () {
    if(symbol>66){
        $('#tr0').find('th:last').remove();
        $('.tBody').find('tr').each(function () {
            $(this).find('td:last').remove();
        });
        symbol--;
    }
});
$('#btnDelRow').on("click", function () {
    if(iter>2){
        $('.table tr:last').remove();
        iter--;
    }
});
$('#btnAddRow').click(function () {
    let thisId = "tr" + iter;
    $('.tBody tr:last').clone().attr('id', function () { return thisId;}).appendTo('tBody');
    let ex = document.getElementById(thisId);
    ex.firstElementChild.innerHTML = iter;
    let exs = ex.children;
    function chName (td) {
        let inp = td.getElementsByTagName('input');
        let inpId = inp[0].id;
        let letter = inpId.charAt(0);
        inp[0].id = letter+iter;
    }
    for(let i = 1; i < exs.length; i++){
        chName(exs[i]);
    }
    iter++;
});
    //Logic for saving changes
    $('#btnSaveChanges').click(function () {
        let url = "http://localhost:8181/edittable";
        let valuesMap = [];
        valuesMap[0] = new Object({tblname:currentTableName});
        let iterat = 1;
        $('.table').find('td').each(function () {
            let idEx = $(this).find('input').attr('id');
            let vall = $(this).find('input').val();
            if(idEx!==undefined){
                valuesMap[iterat]=new Object({idEx : idEx, vall : vall});
                iterat++;
            }
        });
        let serializedMap = JSON.stringify(valuesMap);
        $.ajax({
            url : url,
            method : "post",
            data : serializedMap,
            dataType: "text",
            success : function (msg) {
                document.getElementById('savedChanges').style.display = 'block';
                setTimeout(function () {
                    document.getElementById('savedChanges').style.display = 'none';
                },5000)
            },
            error: function (msg) {
                console.log(msg);
            }
        })
    });
//Creating table form buttons
$('#createTableFrm').on("submit", function (event) {
    event.preventDefault();
    currentTableName = $('#tblname').val();
    let tblname = {
        "tblname": currentTableName
    };
    const url = "http://localhost:8181/createtable";

    $.ajax({
        url: url,
        method: "post",
        data: tblname,
        dataType:"text",
        success: function() {
            document.getElementById('closeCreateDialog').dispatchEvent(new MouseEvent("click"));
            document.getElementById('curTableName').innerText = 'Current Table - '+currentTableName;
            document.getElementById('hidelink').dispatchEvent(new MouseEvent("click"));

        },
        error: function (msg) {
            console.log(msg);
        }
    });
});
//Logic Edit form
$('#submitGet').click(function () {
    const url = "http://localhost:8181/gettables";
    $.ajax({
        url: url,
        method: "get",
        dataType: "json",
        success: function (data) {
            let tables = data;
            let elem = document.getElementById('ulTablesMap');
            if(elem!=null){
                elem.remove();
            }
            let inputDot = $('#tablesMap');
            inputDot.append('<div><ul id="ulTablesMap"></ul></div>');
            for (let it = 0; it < tables.length; it++) {
                $('#ulTablesMap').append('<li><label><input type="radio" name="radCheck" id="rad' + tables[it] + '"/>' + tables[it] + '</label></li>');
            }
        }
    })
});
$('#redirectEdit').click(function () {
    const url = "http://localhost:8181/datagetter";
    let nameEd = $("input:radio:checked").attr('id').slice(3);
    $.ajax({
        url:url,
        method:"post",
        data: nameEd,
        success: function (resList) {
            if(resList.length !== 0){
                document.getElementById('tableFormForEdit').remove();
                let resultIter = 0;
                let lstSym = resList[resList.length-1].idEx.charAt(0);
                let lstNum = resList[resList.length-1].idEx.slice(1);
                symbol = lstSym.charCodeAt(0);
                ++symbol;
                iter = lstNum;
                ++iter;
                let lstSymNum = lstSym.charCodeAt(0);
                let columnCount = lstSymNum - 64;
                let stringCount = lstNum;
                let tempThString = '';
                let tmpTrString = '';
                for(let th0 = 65; th0<=lstSymNum; th0++){
                    let tempTh = String.fromCharCode(th0);
                    tempThString +='<th>'+tempTh+'</th>';
                }
                tempThString+='</tr>';
                for(let i = 1; i<=stringCount; i++){
                    tmpTrString+='<tr id="tr'+i+'" class="tr">' +
                        '<td class="td-number">'+i+'</td>';
                    for(let j = 0; j<columnCount;j++){
                        let thisId = resList[resultIter].idEx;
                        let thisVal = resList[resultIter].vall;
                        tmpTrString+='<td><label>' +
                            '<input type="text" id="'+thisId+'" placeholder="Value" value="'+thisVal+'">' +
                            '</label></td>';
                        resultIter++;
                    }
                    tmpTrString+='</tr>';
                }
                $('#gotTableFromDB').append('<table class="table" id="tableFormForEdit">\n' +
                    '<tbody class="tBody"><tr id="tr0" class="tr"><th scope="col">&nbsp;</th>\n' +
                    tempThString+tmpTrString+'</tbody></table>');
                document.getElementById('hidelink').dispatchEvent(new MouseEvent("click"));
            } else {
                alert('Empty table');
            }


        },
        error: function (msg) {
            alert('Empty table');
        }
    })
});
//Logic Delete form
$('#getTblsForDel').click(function () {
    const url = "http://localhost:8181/gettables";
    $.ajax({
        url: url,
        method: "get",
        dataType: "json",
        success: function (data) {
            let tables = data;
            let elem = document.getElementById('ulTablesMapDel');
            if(elem!=null){
                elem.remove();
            }
            let inputDot = $('#tablesMapDel');
            inputDot.append('<div><ul id="ulTablesMapDel"></ul></div>');
            for(let it = 0; it<tables.length; it++){
                $('#ulTablesMapDel').append('<li><label><input type="radio" name="radCheck" id="rad'+tables[it]+'"/>'+tables[it]+'</label></li>');
            }
        }
    })
});
$('#submitDelete').click(function () {
    const url = "http://localhost:8181/deletetable";
    let name = $("input:radio:checked").attr('id').slice(3);
    $.ajax({
        url: url,
        method:"post",
        data: name,
        success: function () {
            document.getElementById('getTblsForDel').dispatchEvent(new MouseEvent("click"));
            },
        error: function (msg) {
            console.log(msg);
        }
    })
});
