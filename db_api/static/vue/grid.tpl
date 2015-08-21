<style type="text/css">

	body {
    	font-family: Helvetica Neue, Arial, sans-serif;
	}

	li.done {
	    text-decoration: line-through;
	}
	body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -user-select: none;
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}

th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}

#search {
  margin-bottom: 10px;
}
	</style>

<table>
	<thead>
			<tr>
				<th v-repeat='key in columns' v-on='click:sortBy(key)' v-class='active: sortKey == key'>{{key}}
					<span class='arrow' v-class='revered[key]?"desc":"asc"'></span>
				</th>
			</tr>
		</thead>
		<tbody>

			<tr v-repeat="entry: systems
				        | filterBy filterKey
				        | orderBy sortKey reversed[sortKey]" >
				<td v-repeat='key : columns'>{{entry[key]}}</td>
				
			</tr>
		</tbody>
</table>