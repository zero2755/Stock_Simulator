 $("#div1234").on("click",function(){      
	alert("2");
	
})


	$(document).ready(function(){
		
		 $("#div123").on("click",function(){      
			$.ajax({
				
				type : "GET",
				url : "/getSingleStock.po",
				//url : contextPath + '/drilldown/kill.po',
				dataType : "text",
				error : function(why){
					 
					console.log(why);
					alert('통신실패!!');
				},
				success : function(data){
					alert("zzzz")
					   
					const Obj_JSON=JSON.parse(data)
					 
					var singleMaxKey=Obj_JSON["1"];
					var singleMaxValue=Obj_JSON["2"];
					var singleMinKey=Obj_JSON["3"];
					var singleMinValue=Obj_JSON["4"];
					console.log("zzz")
					console.log(singleMaxKey,singleMaxValue,singleMinKey,singleMinValue);
					
					delete Obj_JSON["1"]; //최대키값,벨류,최소키값,벨류제거
					delete Obj_JSON["2"];
					delete Obj_JSON["3"];
					delete Obj_JSON["4"];
					
					$("#maxSpanArea").text("날짜 :"+singleMaxKey+" 주가 : "+singleMaxValue)
					$("#minSpanArea").text("날짜 :"+singleMinKey+" 주가 : "+singleMinValue)
					
					/*
					labels=[]
					labels=Object.keys(Obj_JSON);
					console.log("===zz=====")
					testObj=Object.values(Obj_JSON);
					console.log(labels);
					console.log("========")
					console.log(testObj);
					console.log("00000000000")
					console.log(chartData)
					console.log("111111111")
					console.log(chartData.data)
					console.log("2222")
					chartData.data=Object.values(Obj_JSON);
					console.log("333")
					console.log(chartData.data)
					console.log("4444444")
					console.log(chartData)
					chartData.labels=labels;
					*/
				 
					  var chartDataz = {
					    labels:  Object.keys(Obj_JSON),
					    datasets: [{
					      label:  "싱글스톡 주가 추이",
					      backgroundColor: 'rgb(255, 99, 132)',
					      borderColor: 'rgb(255, 99, 132)',
					      data: Object.values(Obj_JSON),
					      fill:false,
					    }]
					  };

					  var chartConfig = {
					    type: 'line',
					    data: chartDataz,
					    options: {}
					  };
					  
					  var myChart = new Chart(
							    document.getElementById('myChart'),
							    chartConfig
							  );
					  
					  //최대값
					  /*
					  var arr1 = Object.keys(Obj_JSON).map(function (key) {
						  console.log(key)
						  console.log("키구분");
						  return Obj_JSON[key]; });
					  var max1 = Math.max.apply(null, arr1);
					  var min1 = Math.min.apply(null, arr1);
					  console.log("zz0")
					  console.log(arr1)
					  console.log("zz1")
					  console.log(max1)
					   console.log("zz2")
					  console.log(min1)
					   */
				
					  
				}
				
			});
		 });
			 
 
	 
		

	});