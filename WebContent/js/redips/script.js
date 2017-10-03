/*jslint white: true, browser: true, undef: true, nomen: true, eqeqeq: true, plusplus: false, bitwise: true, regexp: true, strict: true, newcap: true, immed: true, maxerr: 14 */
/*global window: false, REDIPS: true */

/* enable strict mode */
"use strict";



// define redipsInit variable
var redipsInit;
var rowToDrop;
var redips = {};
// redips initialization


//configuration
redips.configuration = function () {

	redips.hover1 = '#9BB3DA';				// hover color for original elements
	redips.hover2 = '#FFCFAE';				// hover color for cloned elements
	redips.width = '240px';					// width of DIV element dropped to the right table
	redips.left = 'left';					// id of left DIV container
	redips.right = 'right';					// id of right DIV container
	redips.content_url = 'get-content.php';	// get-content URL
	redips.size = {w: 0, h: 0};				// size of DIV elements in question table
};


redipsInit = function () {
	// reference to the REDIPS.drag library and message line
	var	rd = REDIPS.drag, msg;

	// set reference to the hoverDiv
	redips.hoverDiv = document.getElementById('hover-div');
	// initially hide all tables in right container except first table
	//redips.hideTables();
	// set class="single" to the table cells question table (left table)
	//redips.singleContent();
	//set onmouseover & onmouseout to all div elements inside DIV id="drag"
	redips.setEvents();
	redips.configuration();
	// set fixed position for the left container
	//document.getElementById(redips.left).style.position = 'fixed';
	
	// initialization
	rd.init();
	// set hover color for TD and TR
	rd.hover.colorTd = '#FFCFAE';
	rd.hover.colorTr = '#9BB3DA';
	// set hover border for current TD and TR
	rd.hover.borderTd = '2px solid #32568E';
	rd.hover.borderTr = '2px solid #32568E';
	// drop row after highlighted row (if row is dropped to other tables)
	rd.rowDropMode = 'after';
	
	// row was clicked - event handler
	rd.event.rowClicked = function () {
		// set current element (this is clicked TR)
		var el = rd.obj;
		// find parent table
		el = rd.findParent('TABLE', el);
		// every table has only one SPAN element to display messages
		msg = el.getElementsByTagName('span')[0];
		msg = document.getElementById('message');
		// display message
		msg.innerHTML = 'Row Clicked';
	};
	// row was moved - event handler
	rd.event.rowMoved = function () {
		// set opacity for moved row
		// rd.obj is reference of cloned row (mini table)
		rd.rowOpacity(rd.obj, 85);
		// set opacity for source row and change source row background color
		// rd.objOld is reference of source row
		rd.rowOpacity(rd.objOld, 20, 'White');
		// display message
		msg.innerHTML = 'Row moved';
	};
	// row was not moved - event handler
	rd.event.rowNotMoved = function () {
		msg.innerHTML = 'Row not moved';
	};
	// row was dropped - event handler
	rd.event.rowDropped = function () {
		// display message
		msg.innerHTML = 'Row dropped';
	};
	// row was dropped to the source - event handler
	// mini table (cloned row) will be removed and source row should return to original state
	rd.event.rowDroppedSource = function () {
		// make source row completely visible (no opacity)
		rd.rowOpacity(rd.objOld, 100);
		// display message
		msg.innerHTML = 'Row dropped to the source';
	};
	/*
	// how to cancel row drop to the table
	rd.event.rowDroppedBefore = function () {
		//
		// JS logic
		//
		// return source row to its original state
		rd.rowOpacity(rd.objOld, 100);
		// cancel row drop
		return false;
	}
	*/
	// row position was changed - event handler
	rd.event.rowChanged = function () {
		// get target and source position (method returns positions as array)
		var pos = rd.getPosition();
		// display current table and current row
		msg.innerHTML = 'Row changed: ' + pos[0] + ' ' + pos[1];
	};
	rd.event.clicked = function () {
		msg = document.getElementById('message');
		//getLOArray();
		//getLO("1");
		var x = rd.obj.getAttribute("id");
		//getLO(x);
		//alert("result " + getLO(x));
		//alert(lodet[getLO(x)][4]);
		msg.innerHTML = lodet[getLO(x)][2] +" "+ lodet[getLO(x)][3] + " " + lodet[getLO(x)][4] + " " + lodet[getLO(x)][5];
	};
	rd.event.dropped = function() {
		   // get target and source position (method returns positions as array)
		   // pos[0] - target table index
		   // pos[1] - target row index
		   // pos[2] - target cell (column) index
		   // pos[3] - source table index
		   // pos[4] - source row index
		   // pos[5] - source cell (column) index
		   var pos = rd.getPosition();
		   // display element positions
		   console.log(pos);
		   if (pos[3]===1) {
			   dRt2(pos[4]);
		   }
	}
};

function load() {
	getJSON();
	getLOArray();
	//REDIPS.drag.clearTable('tbl1');
	REDIPS.drag.loadContent('tbl1', json);
	msg = document.getElementsByTagName('span')[0];
	msg.innerHTML = "Loaded";
	//REDIPS.drag.loadContent('tbl1', [["d6", 0, 1, "green", "B1"], ["d6", 6, 2, "green", "B2"], ["d7", 6, 3, "green", "B3"]]);
};

function save() {
	// define table_content variable
	var table_content;
	// prepare table content of first table in JSON format or as plain query string (depends on value of "type" variable)
	table_content = REDIPS.drag.saveContent('tbl1', 'json');
	jsonnew = table_content;
	setJSON();
	//window.open('multiple-parameters-json.php?p=' + table_content, 'Mypop', 'width=360,height=260,scrollbars=yes');
	// if content doesn't exist
	if (!table_content) {
		msg.innerHTML = 'Table is empty - not saved';
	}
	// display query string
	else {
		msg.innerHTML = 'Table successfully saved';
		//window.open('/my/multiple-parameters-json.php?p=' + table_content, 'Mypop', 'width=350,height=260,scrollbars=yes');
		//window.open('multiple-parameters-json.php?p=' + table_content, 'Mypop', 'width=360,height=260,scrollbars=yes');
	}
}

function appendRow() {
    var tbl = document.getElementById('tbl1'), // table reference
        row = tbl.insertRow(tbl.rows.length),      // append table row
        i;
    // insert table cells to the new row
    row.className = "rl";
        
    for (i = 0; i < tbl.rows[1].cells.length; i++) {
    	if (i==0){
    		createCell(row.insertCell(i), "", "redips-drag redips-row");
    	} else {
    		createCell(row.insertCell(i), "", '');
    	}
    }
}

function createCell(cell, text, style) {
    if (style==="redips-drag redips-row"){
    	cell.setAttribute("class", "redips-rowhandler");    	
    	cell.setAttribute("className", "redips-rowhandler");
    }
	var div = document.createElement('div')  //, // create DIV element
    //    txt = document.createTextNode(text); // create text node
    //div.appendChild(txt);                    // append text node to the DIV
    div.setAttribute('class', style);        // set DIV class attribute
    div.setAttribute('className', style);    // set DIV class attribute for IE (?!)
    cell.appendChild(div);                   // append DIV to the table cell

    
}

function dRt2(rownumber) {
	var tbl = document.getElementById('tbl2');
	tbl.deleteRow(rownumber);
}

function deleteRows() {
    var tbl = document.getElementById('tbl1'), // table reference
        lastRow = tbl.rows.length - 1;         // set the last row index
    //    i;
    // delete rows with index greater then 0
    //for (i = lastRow; i > 0; i--) {
        tbl.deleteRow(lastRow);
    //}
}

//LO-Viewer
//show tooltip (when mouse is over element of question table) 
redips.showTooltip = function (e) {
	var element = e.target || e.srcElement,	// define element from the fired event
		id = element.id,					// id of the DIV element is question ID (written as inner HTML)
		box = element,						// remember box object (needed for offset calculation)
		scrollPosition,						// scroll position
		oTop, oLeft;						// offset Top & offset Left
	// get scroll position and include scroll position in offset calculation
	// use REDIPS.drag.getScrollPosition() for scroll position
	scrollPosition = REDIPS.drag.getScrollPosition();
	oLeft = scrollPosition[0];
	oTop = scrollPosition[1];
	// loop to the root element and return box offset (top, right, bottom, left)
	do {
		oLeft += box.offsetLeft;
		//oTop += box.offsetTop;
		box = box.offsetParent;
	}
	while (box && box.nodeName !== 'BODY');
	// set popup near to the element
	redips.hoverDiv.style.top  = (oTop + 300) + 'px';
	redips.hoverDiv.style.left = oLeft + 'px';
	// make AJAX call - input parameter is question id (DIV element)
	// obj property is reference to the object where AJAX output will be displayed (see redips.handler) 
	//div = document.getElementById('hover-div');
	//div.innerHTML = "TEST";
	//var x = REDIPS.obj.getAttribute("id");
	redips.hoverDiv.innerHTML = lodet[getLO(id)][2] +" "+ lodet[getLO(id)][3] + " " + lodet[getLO(id)][4] + " " + lodet[getLO(id)][5];
	//redips.hoverDiv.innerHTML = "TEST transparency";
	//REDIPS.drag.ajaxCall(redips.content_url + '?id=' + id, redips.handler, {div: redips.hoverDiv});
	// set visibility
	redips.hoverDiv.style.visibility = 'visible';
};

//hide tooltip
redips.hideTooltip = function () {
	//redips.hoverDiv.style.visibility = 'visible';
	redips.hoverDiv.style.visibility = 'hidden';	
};


//set onmouseover & onmouseout to all div elements inside DIV id="drag"
redips.setEvents = function () {
	var regex_drag = /\bdrag\b/i,	// regular expression to search "drag" class name
		div, i;
	// collect all div elements inside DIV id="drag"
	div = document.getElementById('redips-drag').getElementsByTagName('div');

	for (i = 0; i < div.length; i++) {
		// only DIV elements that contains "drag" in class name
		if (regex_drag.test(div[i].className)) {
			REDIPS.event.add(div[i], 'mouseover', redips.showTooltip);
			REDIPS.event.add(div[i], 'mouseout', redips.hideTooltip);
			
		}
	}
	// remember size (width and height) of DIV elements in question table
	// needed in case when element is returned to the left table
	//redips.size.w = div[0].style.width;
	//redips.size.h = div[0].style.height;
};



// add onload event listener
if (window.addEventListener) {
	window.addEventListener('load', redipsInit, false);
}
else if (window.attachEvent) {
	window.attachEvent('onload', redipsInit);
}