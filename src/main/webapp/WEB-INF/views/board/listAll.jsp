<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

    
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

            <!-- general form elements -->
            <div class='box'>
                <div class="box-header with-border">
                    <h3 class="box-title">Board List</h3>
                </div>
                <div class='box-body'>
                    <!-- 추가  -->
                    <select name="searchType" id="searchType">
                        <option value="title">제목</option>
                        <option value="writer">작성자</option>
                    </select> 
                    <input type="text" name='searchKeyword' id="searchKeyword">
                    <button id='searchBtn'>Search</button>
                </div>
            </div>    
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>
						
						<tbody id="tbody">
						
							<c:forEach items="${boardlists}" var ="board">
								<tr>
									<td>${board.seq}</td>
									<td><a href='/board/read.sinc?seq=${board.seq}'>${board.title}</a></td>
									<td>${board.writer}</td>
									<td>${board.regdate}</td>
									<td><span class="badge bg-red">${board.cnt}</span></td>
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
                    <button class="btn btn-primary" id="writeBtn">글쓰기</button>
                </div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

	<script>
    
	   $(document).ready(function() {
		 
		    // {선택자).함수이름();
	   
		    $("#searchBtn").click(function() {
		    	 $("#tbody").empty();    // 지우기
		    	
		    	 /*
		    	 var obj = {kkey:value, key:value}
		    	 var ary=[{},{},{}]}
		    	 
		    	  */
		    	 
		    	 $.ajax({
		    		 url  : "/board/search.sinc",
		    	     type : "post",
		    	     data : { searchType : $("#searchType").val(),
		    	    	      searchKeyword : $("#searchKeyword").val()
		    	     },
		    	     dataType : "json", 
		    	     success : function(list){
		    	    	var txt="";
                        $.each(list , function(idx, obj) {
                            txt +="<tr>";
                            txt +="<td>"+obj.seq+"</td>";
                            txt +="<td><a href='/board/read.sinc?seq="+obj.seq+"'>"+obj.title+"</a></td>";
                            txt +="<td>"+obj.writer+"</td>";
                            txt +="<td>"+obj.regdate+"</td>";
                            txt +="<td><span class='badge bg-red'>"+obj.cnt+"</span></td>";
                            txt +="</tr>";
                        });
                        $("#tbody").html(txt);
		    	     }
		    	 });
		    });
	   })
        
    </script>

<%@include file="../include/footer.jsp"%>
