<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Exscel</title>
    <link rel="stylesheet" href="css/table_page.css">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<div>
    <div>
        <h1>Web Excel</h1>
    </div>
    <div>
        <ul class="main-operations">
            <li>
                <form class="create-tbl-btn" id="createTableFrm">
                    <a href="#openCreateDialog" class="asbtn">Create table</a>
                    <div id="openCreateDialog" class="modalDialog">
                        <div>
                            <a id="closeCreateDialog" href="#close" title="Закрыть" class="close">X</a>
                            <h2>Creating table</h2>
                            <p>Enter table name:</p>
                            <input type="text" name="tblname" class="form-control" id="tblname" placeholder="Enter table name">
                            <button type="submit" name = "submit" class="btn btn-primary" id="submitCreate" value="Submit">Submit</button>
                        </div>
                    </div>
                </form>
            </li>
            <li>
                <form class="edit-table-btn">
                    <a href="#openEditDialog" class="asbtn">Edit Table</a>
                    <div id="openEditDialog" class="modalDialog">
                        <div>
                            <a href="#close" title="Закрыть" class="close">X</a>
                            <h2>Select Table For Edit</h2>

                            <button type="button" class="btn btn-primary" id="submitGet" value="Get Tables">Get Tables</button>
                            <button type="button" class="btn btn-primary" id="redirectEdit" value="Let Edit">Let Edit</button>
                            <div>
                                <div id="tablesMap"></div>
                            </div>
                        </div>
                    </div>
                </form>
            </li>
            <li>
                <form class="delete-table-btn">
                    <a href="#openDeleteDialog" class="asbtn">Delete table</a>
                    <div id="openDeleteDialog" class="modalDialog">
                        <div>
                            <a href="#close" title="Закрыть" class="close">X</a>
                            <h2>Select table For Delete</h2>
                            <button type="button" class="btn btn-primary" id="getTblsForDel" value="Get Tables">Get Tables</button>
                            <button type="button" class="btn btn-primary" id="submitDelete" value="Delete">Delete</button>
                            <div>
                                <div id="tablesMapDel"></div>
                            </div>
                        </div>
                    </div>
                </form>
            </li>
        </ul>
    </div>
</div>

<div class="hideddive">
    <<input type="text" id="hidcurtblname" name="currentTableName" value=""/>
    <div>
        <form id="tableForm" class="editing-tbl-btn" method="post" action="/edittable">
            <a id="hidelink" href="#tableEditor">Editing table</a>
            <div  id="tableEditor" class="modalDialog">
                <div>
                    <a href="#close" title="Закрыть" class="close">X</a>
                    <div id="curTableName">Current Table</div>
                    <div id="savedChanges"><p>Changes were saved</p></div>
                    <div id="buttons">
                        <button type="button" id="btnAddColumn" class="addCol">Add column</button>
                        <button type="button" id="btnDeleteCol" class="delCol">Delete column</button>
                        <button type="button" id="btnAddRow" class="addRow">Add row</button>
                        <button type="button" id="btnDelRow" class="delRow">Delete last row</button>
                    </div>
                    <div id="gotTableFromDB"></div>
                    <table class="table" id="tableFormForEdit">
                        <tbody class="tBody">
                        <tr id="tr0" class="tr">
                            <th scope="col">&nbsp;</th>
                            <th>A</th>
                        </tr>
                        <tr id="tr1" class="tr">
                            <td class="td-number">1</td>
                            <td>
                                <label>
                                    <input type="text" id="A1" placeholder="Value" value="">
                                </label>
                            </td>

                        </tr>
                        </tbody>
                    </table>
                    <input id="btnSaveChanges" name="sub" type="button" value="SAVE">
                </div>
            </div>
        </form>
    </div>
</div>
<script src="/javascript/jquery-3.3.1.js"></script>
<script src="/javascript/index.js"></script>
</body>
</html>
