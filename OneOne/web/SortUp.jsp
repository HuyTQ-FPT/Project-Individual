
<%@page import="model.DAOProducts"%>
<%@page import="entity.Productitem"%>
<%@page import="model.DAOCustomers"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.Products"%>
<!DOCTYPE html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="icon" href="img/favicon.png" type="image/png" />
    <title>Home</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="vendors/linericon/style.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/themify-icons.css" />
    <link rel="stylesheet" href="css/flaticon.css" />
    <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css" />
    <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css" />
    <link rel="stylesheet" href="vendors/animate-css/animate.css" />
    <link rel="stylesheet" href="vendors/jquery-ui/jquery-ui.css" />
    <!-- main css -->
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/responsive.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
        .container-table-content{
            margin-left: 650px; 
            justify-content: center;
        }
        .pagination > li > a
    {
        background-color: white;
        color: green
    }
     
    .page-item.active .page-link
    {
        background-color:green;
        border-color:green
    }
     
    .pagination > li > a:focus,
    .pagination > li > a:hover,
    .pagination > li > span:focus,
    .pagination > li > span:hover
    {
        color: green;
        background-color: #eee;
        border-color: #ddd;
    }
     
    .pagination > .active > a
    {
        color: white;
        background-color: green;
        border: solid 1px green;
    }
 
    .pagination > .active > a:hover
    {
        background-color: green;
        border: solid 1px green;
    }
        .main_menu{
            position: relative;
        }
        .nav navbar-nav navbar-right right_nav pull-right .nav-item .icons{
            position: relative;
        }
        .nav navbar-nav navbar-right right_nav pull-right .nav-item .number{
            position: absolute;
            margin-top: 10px;
            right: 4px;
        }
        .log-out{
            color: white;
            font-size: 15px;
            margin-top: 20px;
            margin-left: 30px;
            border-radius: 15px;
            background-color: #71CD14;
            cursor: pointer;
            transition: 0.5s;
            border: 1px solid greenyellow;
        }
        .log-out:hover{
            color: #71CD14;
            background-color: white;
        }
        .register{
          
            top:20px;
            right:100px;
            color: white;
            font-size: 15px;
            border-radius: 15px;
            background-color: #71CD14;
            cursor: pointer;
            transition: 0.5s;
            border: 1px solid greenyellow;
        }
        .register:hover{
            color: #71CD14;
            background-color: white;
        }
        .not-yet-loigin-logout{
            position: relative;
        }
        .not-yet-loigin-register{
            position: absolute;
            top: 20px;
            right: -100px;
        }
        .welcome{ 
            position: fixed;
            color: #040505;
            font-family: fantasy;
            font-size: 20px;
            margin-right: 20px;
            left: 40px;
        }
        .search{
            position: absolute;
            display:none;
            color: white;
            margin: 20px;
            right: 0px;
        }
        .search-name .button{
            background-color: lightskyblue;
            border-radius: 10px;
        }
        .search .input-searchname{
            border-radius: 5px;
            width: 120px;
            height:25px;
        }
        .search .input-searchprice{
            border-radius: 5px;
            width: 50px;
            height:25px;
        }
        form-control{
            position: relative;
        }
        .sot{
            background-color: white;
            position: absolute;
            right: 5px;
            top:86px;
            border: none;
            border: 1px solid #71CD14;
            height: 25px;
            border-radius: 2px;
            transition: 0.1s;
            font-size: 12px;
        }
        .sot:hover{
            font-size: 11px;;
           
        }      
        .activeS{
            background-color: #71CD14;
        }
    </style>
</head>

<body>
    <%
        DAOProducts dao = new model.DAOProducts();
        Vector<Products> vector = (Vector<Products>) request.getAttribute("list");
         Vector<Products> vector2 = (Vector<Products>)dao.listAllProduct("");
//            Vector<Customers> ac = (Vector<Customers>)request.getAttribute("account");          
        String titletable = (String) request.getAttribute("titletable");
        ResultSet rs1 = dao.getData("select * from Categories");
            int size_page=24;
        java.util.Enumeration numberBill = session.getAttributeNames(); 
                    int total=0;
                    while (numberBill.hasMoreElements()) {
                        String key = numberBill.nextElement().toString();
                        Productitem pro = (Productitem) session.getAttribute(key);
                        if(key!="login" && key!="admin"){
                        total+=1;
                        }
                    }
    String rs ="";
        int count=0;
        if(session.getAttribute("login")!=null){
            Productitem pro = (Productitem) session.getAttribute("login");
            rs=pro.getUsername();
            count=2;
        } else{
            count=1;
        }
    %> 
    <!--================Header Menu Area =================-->
    <header class="header_area">
        <div class="main_menu">
            <div class="container">                   
                <nav class="navbar navbar-expand-lg navbar-light w-100">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <%if (count==2) {%><h3 class="welcome" style="color:#71CD14;"> Xin Chao: <%=rs%></h3><%}%>
                    <a class="navbar-brand logo_h" href="ControllerAddtoCart?do=listAllProduct">
                        <img style="padding-left:60px;" src="img/logo.png" alt="" />
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse offset w-100" id="navbarSupportedContent">
                        <div class="row w-100 mr-0">
                            <div class="col-lg-7 pr-0">
                                <ul class="nav navbar-nav center_nav pull-right">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="index.jsp">Home</a>
                                    </li>
                                    <li class="nav-item submenu dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                           aria-expanded="false">Shop</a>
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a class="nav-link" href="category.jsp">Shop Category</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="checkout.jsp">Product Checkout</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="cart.jsp">Shopping Cart</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-item submenu dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                           aria-expanded="false">Blog</a>                                 
                                    </li>
                                    <li class="nav-item submenu dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                           aria-expanded="false">Pages</a>                                       
                                    </li>
                                    <li class="nav-item submenu dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                           aria-expanded="false">Sorting By Price</a>
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a class="nav-link" href="ControllerAddtoCart?do=listAllProduct">Normal</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link activeS" href="ControllerSort?do=Sort_Max_to_Min">Max -> Min</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="ControllerSort?do=Sort_Min_to_Max">Min -> Max</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>

                            <div class="col-lg-5 pr-0">
                                <ul class="nav navbar-nav navbar-right right_nav pull-right">                                   
                                    <li accesskey="" class="nav-item">
<!--                                        <a href="#" class="icons" onclick="if (document.getElementById('search').style.display == 'none') {
                                                    document.getElementById('search').style.display = 'block';
                                                } else {
                                                    document.getElementById('search').style.display = 'none';
                                                }">-->
                                        <a href="#" class="icons">
                                            <i class="ti-search" aria-hidden="true"></i>
                                        </a>
                                        <span class="number"></span>
                                    </li>

                                    <li class="nav-item">
                                        <a href="cart.jsp" class="icons">
                                            <i class="ti-shopping-cart"></i>
                                        </a>
                                        <span id="cart-number" class="number"><%=total%></span>
                                    </li>

                                    <li class="nav-item">
                                        <a href="#" class="icons">
                                            <i class="ti-user" aria-hidden="true"></i>
                                        </a>
                                        <span class="number"></span>
                                    </li>

                                    <li class="nav-item">
                                        <a href="#" class="icons">
                                            <i class="ti-heart" aria-hidden="true"></i>
                                        </a>
                                        <span class="number"></span>
                                    </li>
                                    <li>
                                        <%if (count==2) {%>
                                        <form action="ControllerLogin?do=Logout" method="post">
                                            <button type="submit" name="log-out" class="log-out">Log Out</button>
                                        </form>
                                    </li>
                                        <%} else {%>
                                        <div class="not-yet-loigin-logout">
                                            <form action="ControllerLogin?do=Login" method="post">
                                                <button type="submit" name="log-out" class="log-out">Login</button>            
                                            </form>
                                            <div class="not-yet-loigin-register">
                                                <form action="ControllerLogin?do=register" method="post">
                                                      <button type="submit" name="register" class="register">Register</button>            
                                                 </form>
                                            </div>
                                        </div>                                                                               
                                    <li>                                       
                                    </li>
                                    <%}%>
                                    </li>
                                </ul>
                                  <!--search name-->
                                  <ul >
                                      <form action="ControllerAddtoCart?do=Search" method="post">
                                          <li>
                                            <div class="md-form mt-0">
                                                <input class="form-control" name="name" type="text" placeholder="Search" aria-label="Search" value="">
                                                <div>
                                                    <input type="submit" value="Search" class="sot">
                                                </div>                                                                        
                                            </div>
                                        </li>
                                      </form>                                       
                                    </ul>                                   
                            </div>
                        </div>
                    </div>
                </nav>
            </div>            
        </div>
    </header>
    <!--================Header Menu Area =================-->

    <!--================Home Banner Area =================-->
    <section class="home_banner_area mb-40">
        
        <div class="banner_inner d-flex align-items-center">
            <div class="container">
                <div class="banner_content row">
                    <div class="col-lg-12">
                        <p class="sub text-uppercase">men Collection</p>
                        <h3><span>Show</span> Your <br />Personal <span>Style</span></h3>
                        <h4>Fowl saw dry which a above together place.</h4>
                        <a class="main_btn mt-40" href="#">View Collection</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--  ================End Home Banner Area =================

    <!--================ Feature Product Area =================-->

    <section class="new_product_area section_gap_top section_gap_bottom_custom">
        <div class="container">
            <div class="row">
                <%  int pagePro=(int)Integer.parseInt(request.getAttribute("page").toString());
                    if(vector.size()>size_page-1){
                    for (int i= vector.size()-1; i >12; i--) {%>
                <div class="col-lg-3 col-md-6">  
                    <div class="single-product">
                        <div class="product-img">
                            <img class="img-fluid w-100" style="height:250px;overflow: hidden;" src="<%=vector.get(i).getimage()%>" alt="" />
                            <div class="p_icon">
                                <a href="ControllerDetailProduct?do=detail&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-eye"></i>
                                </a>
                                    <a id="<%=vector.get(i).getProductID()%>" onclick="document.getElementById('<%=vector.get(i).getProductID()%>').style.backgroundColor ='red'
                                       ">
                                    <i class="ti-heart"></i>
                                </a>
                                <a href="ControllerAddtoCart?do=AddtoCart&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-shopping-cart"></i>
                                </a>             
                            </div>
                        </div>
                        <div class="product-btm">
                            <a href="#" class="d-block">
                                <h4><%=vector.get(i).getProductName()%></h4>
                            </a>
                            <div class="mt-3">
                                <span class="mr-4">$<%=vector.get(i).getUnitPrice()%></span>
                                <del>$50.00</del>
                            </div>
                        </div>
                    </div>
                </div> 
                <%}%>
            </div>
    </section>
    <!--================ End Offer Area =================-->

    <!--================ New Product Area =================-->
    <section class="new_product_area section_gap_top section_gap_bottom_custom">
        <div class="container">
            <div class="row">
                <% for (int i =12; i >= 12; i--) {%>
                <div class="col-lg-6">
                    <div class="new_product">
                        <h5 class="text-uppercase">collection of 2022</h5>
                        <h3 class="text-uppercase">Men summer t-shirt</h3>                        
                        <div class="product-img">
                            <img class="img-fluid w-750" style="height:310px;overflow: hidden;" src="<%=vector.get(i).getimage()%>" alt="" />
                        </div>
                        <h3 class="text-uppercase"><%=vector.get(i).getProductName()%></h3>
                        <h4>$<%=vector.get(i).getUnitPrice()%></h4>
                        <a href="ControllerAddtoCart?do=AddtoCart&pid=<%=vector.get(i).getProductID()%>" class="main_btn">Add to cart</a>
                    </div>
                </div>
                <%}%>
                
                <div class="col-lg-6 mt-5 mt-lg-0">
                    <div class="row">
                        <% for (int i = 11; i >= 8; i--) {%>
                        <div class="col-lg-6 col-md-6">
                            <div class="single-product">
                                <div class="product-img">
                                    <img class="img-fluid w-100" style="height:255px;overflow: hidden;" src="<%=vector.get(i).getimage()%>" alt="" />
                                    <div class="p_icon">
                                        <a href="ControllerDetailProduct?do=detail&pid=<%=vector.get(i).getProductID()%>">
                                            <i class="ti-eye"></i>
                                        </a>
                                        <a href="#">
                                            <i class="ti-heart"></i>
                                        </a>
                                        <a href="ControllerAddtoCart?do=AddtoCart&pid=<%=vector.get(i).getProductID()%>">
                                            <i class="ti-shopping-cart"></i>
                                        </a>
                                    </div>
                                </div>
                                <div class="product-btm">
                                    <a href="#" class="d-block">
                                        <h4><%=vector.get(i).getProductName()%></h4>
                                    </a>
                                    <div class="mt-3">
                                        <span class="mr-4">$<%=vector.get(i).getUnitPrice()%></span>
                                        <del>$35.00</del>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}%>                    
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================ End New Product Area =================-->

    <!--================ Inspired Product Area =================-->
    <section class="inspired_product_area section_gap_bottom_custom">
        <div class="container">
            <div class="row">
                <% for (int i = 7; i >=0; i--) {%>
                <div class="col-lg-3 col-md-6">
                    <div class="single-product">
                        <div class="product-img">
                            <img class="img-fluid w-100" style="height:255px;overflow: hidden;" src="<%=vector.get(i).getimage()%>" alt="" />
                            <div class="p_icon">
                                <a href="ControllerDetailProduct?do=detail&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-eye"></i>
                                </a>
                                <a href="#">
                                    <i class="ti-heart"></i>
                                </a>
                                <a href="ControllerAddtoCart?do=AddtoCart&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-shopping-cart"></i>
                                </a>
                            </div>
                        </div>
                        <div class="product-btm">
                            <a href="#" class="d-block">
                                <h4><%=vector.get(i).getProductName()%></h4>
                            </a>
                            <div class="mt-3">
                                <span class="mr-4">$<%=vector.get(i).getUnitPrice()%></span>
                                <del>$35.00</del>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>                
            </div>
        </div>
    </section>
                        
    <div class="container-table-content">                  
  <ul class="pagination">
      <%for(int i=1;i<=(vector2.size()/size_page)+1;i++){%>
    <li class="page-item <%=pagePro==i?"active":""%>"><a class="page-link" href="ControllerSort?do=PageProductSort_MaxtoMin&page=<%=i%>"><%=i%></a>
    </li>
    <%}%>   
  </ul>
</div>
    <%} else if(pagePro==((vector2.size()/size_page)+1)){
for (int i = vector.size()-1; i >=0; i--) {%>
                <div class="col-lg-4 col-md-6">  
                    <div class="single-product">
                        <div class="product-img">
                            <img class="img-fluid w-100" style="height:350px;overflow: hidden;" src="<%=vector.get(i).getimage()%>" alt="" />
                            <div class="p_icon">
                                <a href="ControllerDetailProduct?do=detail&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-eye"></i>
                                </a>
                                    <a id="<%=vector.get(i).getProductID()%>" onclick="document.getElementById('<%=vector.get(i).getProductID()%>').style.backgroundColor ='red'
                                       ">
                                    <i class="ti-heart"></i>
                                </a>
                                <a href="ControllerAddtoCart?do=AddtoCart&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-shopping-cart"></i>
                                </a>             
                            </div>
                        </div>
                        <div class="product-btm">
                            <a href="#" class="d-block">
                                <h4><%=vector.get(i).getProductName()%></h4>
                            </a>
                            <div class="mt-3">
                                <span class="mr-4">$<%=vector.get(i).getUnitPrice()%></span>
                                <del>$50.00</del>
                            </div>
                        </div>
                    </div>
                </div> 
                <%}%>
            </div>
    </section>
    <div class="container-table-content">                  
  <ul class="pagination">
      <%for(int i=1;i<=(vector2.size()/size_page)+1;i++){%>
    <li class="page-item <%=pagePro==i?"active":""%>"><a class="page-link" href="ControllerSort?do=PageProductSort_MaxtoMin&page=<%=i%>"><%=i%></a>
    </li>
    <%}%>   
  </ul>
</div>
            <%} else{%>
            <%for (int i = vector.size()-1; i >=0; i--) {%>
                <div class="col-lg-4 col-md-6">  
                    <div class="single-product">
                        <div class="product-img">
                            <img class="img-fluid w-100" style="height:350px;overflow: hidden;" src="<%=vector.get(i).getimage()%>" alt="" />
                            <div class="p_icon">
                                <a href="ControllerDetailProduct?do=detail&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-eye"></i>
                                </a>
                                    <a id="<%=vector.get(i).getProductID()%>" onclick="document.getElementById('<%=vector.get(i).getProductID()%>').style.backgroundColor ='red'
                                       ">
                                    <i class="ti-heart"></i>
                                </a>
                                <a href="ControllerAddtoCart?do=AddtoCart&pid=<%=vector.get(i).getProductID()%>">
                                    <i class="ti-shopping-cart"></i>
                                </a>             
                            </div>
                        </div>
                        <div class="product-btm">
                            <a href="#" class="d-block">
                                <h4><%=vector.get(i).getProductName()%></h4>
                            </a>
                            <div class="mt-3">
                                <span class="mr-4">$<%=vector.get(i).getUnitPrice()%></span>
                                <del>$50.00</del>
                            </div>
                        </div>
                    </div>
                </div> 
                <%}%>
            </div>
    </section>
            <%}%>
    <!--================ End Inspired Product Area =================-->

    <!--================ Start Blog Area =================-->

    <!--================ End Blog Area =================-->

    <!--================ start footer Area  =================-->
    <footer class="footer-area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-2 col-md-6 single-footer-widget">
                    <h4>Top Products</h4>
                    <ul>
                        <li><a href="#">Managed Website</a></li>
                        <li><a href="#">Manage Reputation</a></li>
                        <li><a href="#">Power Tools</a></li>
                        <li><a href="#">Marketing Service</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-6 single-footer-widget">
                    <h4>Quick Links</h4>
                    <ul>
                        <li><a href="#">Jobs</a></li>
                        <li><a href="#">Brand Assets</a></li>
                        <li><a href="#">Investor Relations</a></li>
                        <li><a href="#">Terms of Service</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-6 single-footer-widget">
                    <h4>Features</h4>
                    <ul>
                        <li><a href="#">Jobs</a></li>
                        <li><a href="#">Brand Assets</a></li>
                        <li><a href="#">Investor Relations</a></li>
                        <li><a href="#">Terms of Service</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-6 single-footer-widget">
                    <h4>Resources</h4>
                    <ul>
                        <li><a href="#">Guides</a></li>
                        <li><a href="#">Research</a></li>
                        <li><a href="#">Experts</a></li>
                        <li><a href="#">Agencies</a></li>
                    </ul>
                </div>
                <div class="col-lg-4 col-md-6 single-footer-widget">
                    <h4>Newsletter</h4>
                    <p>You can trust us. we only send promo offers,</p>
                    <div class="form-wrap" id="mc_embed_signup">
                        <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                              method="get" class="form-inline">
                            <input class="form-control" name="EMAIL" placeholder="Your Email Address" onfocus="this.placeholder = ''"
                                   onblur="this.placeholder = 'Your Email Address '" required="" type="email">
                            <button class="click-btn btn btn-default">Subscribe</button>
                            <div style="position: absolute; left: -5000px;">
                                <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                            </div>

                            <div class="info"></div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="footer-bottom row align-items-center">
                <p class="footer-text m-0 col-lg-8 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                <div class="col-lg-4 col-md-12 footer-social">
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-dribbble"></i></a>
                    <a href="#"><i class="fa fa-behance"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <!--================ End footer Area  =================-->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/stellar.js"></script>
    <script src="vendors/lightbox/simpleLightbox.min.js"></script>
    <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
    <script src="vendors/isotope/imagesloaded.pkgd.min.js"></script>
    <script src="vendors/isotope/isotope-min.js"></script>
    <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="vendors/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendors/counter-up/jquery.counterup.js"></script>
    <script src="js/mail-script.js"></script>
    <script src="js/theme.js"></script>
</body>

</html>