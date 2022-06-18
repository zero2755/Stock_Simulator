<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
    <head>
    
   
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
         <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.21/lodash.min.js" integrity="sha512-WFN04846sdKMIP5LKNphMaWzU7YpMyCU245etK3g/2ARYbPK9Ub18eG+ljU96qKRCWh+quCY7yefSmlkQw1ANQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js" integrity="sha512-sW/w8s4RWTdFFSduOTGtk4isV1+190E/GghVffMA9XczdJ2MDzSzLEubKAs5h0wzgSJOQTRYyaz73L3d6RtJSg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
          <script type="text/javascript" language="javascript">


</script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.html">Login</a>
                                            <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts123${path}
                            </a>
                            <a class="nav-link" href="tables.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Tables
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">${curDay} => 객체 => ${stockDTO.curPrice}</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#"><%=request.getAttribute("curPrice") %></a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Warning Card</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">추천 매도 시점</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <span id="maxSpanArea">MaxValue</span>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">추천 매입 시점</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <span id="minSpanArea">MinValue</span>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                           	멀티셀렉트 주식 
                                    </div>
                                    <div class="card-body"> 
                                    	 <input id="userId" value="cc2" type="hidden">userid</input>
                                    	 <input name="hobby" value="A005930" type="checkbox">삼성전자</input>
                                    	 <input name="hobby" value="A373220" type="checkbox">에너지솔루션</input>
                                    	 <input name="hobby" value="A000660" type="checkbox">하이닉스</input>
                                     </div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        Bar Chart Example
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                 <div>
  						<canvas id="myChart"></canvas><!-- chart.js -->
								</div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                    
					<div style="background-color:yellow;" id='div123'> 
					<input type="button" id="button1" onclick="abcd();" value="버튼1" />
					</div>
					<div style="background-color:red;" id='multiDiv123'> 
					<input type="button" id="button2" onclick="abcd();" value="버튼2" />
					</div>
					<div style="background-color:blue;" id='div123456'> 
					<input type="button" id="button3" onclick="ajaxExample();" value="chekcboxArr버튼3" />
					</div>
					<div>
					뜸?? ${minValue}
					</div>
                </footer>
            </div>
        </div>
      
         <script>
         //차트키값이여야함
  var labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
  ];
	
         //차트벨류값이여야함
  var chartData = {
    labels: labels,
    datasets: [{
      label: 'My First dataset',
      backgroundColor: 'rgb(255, 99, 132)',
      borderColor: 'rgb(255, 99, 132)',
      data: [0, 10, 5, 2, 20, 30, 45],
      fill:false,
    }]
  };

  var chartConfig = {
    type: 'line',
    data: chartData,
    options: {}
  };
  
  var myChart = new Chart(
		    document.getElementById('myChart'),
		    chartConfig
		  );
	myChart.destroy();
	
	
	function ajaxExample() {
	    // 사용자 ID를 갖고 온다.
	    var userId = $("#userId").val();
	    // name이 같은 체크박스의 값들을 배열에 담는다.
	    var checkboxValues = [];
	    $("input[name='hobby']:checked").each(function (i) {
	        checkboxValues.push($(this).val());
	    });
	    // 사용자 ID(문자열)와 체크박스 값들(배열)을 name/value 형태로 담는다.
	    var allData = {
	        "userId": userId,
	        "checkArray": checkboxValues
	    };
	    console.log(allData);
	    //JSON.stringify(obj)
	    $.ajax({
	        url: "multiStock.po",
	        type: 'POST',
	       // data: {
	         //   data: JSON.stringify(allData)
	          //},
		    contentType:'application/json',
		    data: JSON.stringify(checkboxValues),
		  
		    	
	        
	        success: function (data) {
	            alert("완료!");
	            alert("멀티스톡성공");
				console.log("전");
				//myChart.destroy();
				if( window.lineChart != undefined){
					alert("지우고생성");
	                window.lineChart.destroy();
	            }
				console.log(data);
				
				//var Obj_JSON_MULTI=JSON.parse(data)
				var Obj_JSON_MULTI=data;
				console.log("후")
				console.log(Obj_JSON_MULTI)
				console.log("후")
				var multiMaxKey=Obj_JSON_MULTI["1"];
				var multiMaxValue=Obj_JSON_MULTI["2"];
				var multiMinKey=Obj_JSON_MULTI["3"];
				var multiMinValue=Obj_JSON_MULTI["4"];
				console.log("z23232323z")
				console.log(multiMaxKey,multiMaxValue,multiMinKey,multiMinValue);
				
				delete Obj_JSON_MULTI["1"]; //최대키값,벨류,최소키값,벨류제거
				delete Obj_JSON_MULTI["2"];
				delete Obj_JSON_MULTI["3"];
				delete Obj_JSON_MULTI["4"];
				$("#maxSpanArea").text("날짜 :"+multiMaxKey+" 주가 : "+multiMaxValue)
				$("#minSpanArea").text("날짜 :"+multiMinKey+" 주가 : "+multiMinValue)
				
				//console.log("널11")
				//document.getElementById('myChart')=null
				//console.log("널22")
			 
				  var chartDataz = {
				    labels:  Object.keys(Obj_JSON_MULTI),
				    datasets: [{
				      label:  "멀티스톡 주가 추이",
				      backgroundColor: 'rgb(255, 99, 132)',
				      borderColor: 'rgb(255, 99, 132)',
				      data: Object.values(Obj_JSON_MULTI),
				      fill:false,
				    }]
				  };

				  var chartConfig = {
				    type: 'line',
				    data: chartDataz,
				    options: {}
				  };
				  if(document.getElementById('myChart') != null){
					  //maxSpanArea
					  
					  var myChart = new Chart(
							    document.getElementById('myChart'),
							    chartConfig
					  );
					  myChart.destroy();
				  }
			 
				  console.log("디스ㅡㅌ로이");
				  myChart.destroy();
				  console.log("디스ㅡㅌ로이");
				  var myChart = new Chart(
						    document.getElementById('myChart'),
						    chartConfig
						  );
				  console.log("디스ㅡㅌ로이후");
				  
				  
			 
	          
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
	            self.close();
	        }
	    });
	}
	
</script>

 
 			<script src="${path}/resources/js/drawChart.js"></script>
         <link href="${path}/resources/css/styles.css" rel="stylesheet"/> 
    </body>
</html>
