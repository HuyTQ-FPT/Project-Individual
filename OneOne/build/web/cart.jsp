<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@page import="entity.Productitem"%>
<!DOCTYPE html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
        name="viewport"
        content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />
    <link rel="icon" href="img/favicon.png" type="image/png" />
    <title>Show Cart</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="vendors/linericon/style.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/themify-icons.css" />
    <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css" />
    <link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css" />
    <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css" />
    <link rel="stylesheet" href="vendors/animate-css/animate.css" />
    <link rel="stylesheet" href="vendors/jquery-ui/jquery-ui.css" />
    <!-- main css -->
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/responsive.css" />
    <style>
        .quatity{
            width: 30px;
        }
        .delete-Pro{
            font-size: 20px;
            color: black;
        }
        .delete-All{
            font-size: 30px;
            color: black;          
        }
    </style>
</head>

<body>
    <!--================Header Menu Area =================-->
    <header class="header_area">

        <div class="main_menu">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light w-100">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <a class="navbar-brand logo_h" href="ControllerAddtoCart?do=listAllProduct">
                        <img src="img/logo.png" alt="" />
                    </a>
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div
                        class="collapse navbar-collapse offset w-100"
                        id="navbarSupportedContent"
                        >
                        <div class="row w-100 mr-0">
                            <div class="col-lg-7 pr-0">
                                <ul class="nav navbar-nav center_nav pull-right">
                                    <li class="nav-item">
                                        <a class="nav-link" href="ControllerAddtoCart?do=listAllProduct">Home</a>
                                    </li>
                                    <li class="nav-item active submenu dropdown">
                                        <a
                                            href="#"
                                            class="nav-link dropdown-toggle"
                                            data-toggle="dropdown"
                                            role="button"
                                            aria-haspopup="true"
                                            aria-expanded="false"
                                            >Shop</a
                                        >
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a class="nav-link" href="ControllerCategory"
                                                   >Shop Category</a
                                                >
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="single-product.jsp"
                                                   >Product Details</a
                                                >
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="checkout.jsp"
                                                   >Product Checkout</a
                                                >
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="cart.jsp">Shopping Cart</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-item submenu dropdown">
                                        <a
                                            href="#"
                                            class="nav-link dropdown-toggle"
                                            data-toggle="dropdown"
                                            role="button"
                                            aria-haspopup="true"
                                            aria-expanded="false"
                                            >Blog</a
                                        >
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Blog</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#"
                                                   >Blog Details</a
                                                >
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-item submenu dropdown">
                                        <a
                                            href="#"
                                            class="nav-link dropdown-toggle"
                                            data-toggle="dropdown"
                                            role="button"
                                            aria-haspopup="true"
                                            aria-expanded="false"
                                            >Pages</a
                                        >
                                        <ul class="dropdown-menu">
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Tracking</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="#">Elements</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Contact</a>
                                    </li>
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

    <!--================End Home Banner Area =================-->

    <!--================Cart Area =================-->
    <section class="cart_area">
        <div class="container">
            <div class="cart_inner">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th style="width:300px;"></th>
                                <th scope="col">Product Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total</th>
                                <th></th>
                            </tr>
                        </thead>             
                        <tbody>

                            <%
                                java.util.Enumeration em = session.getAttributeNames();
                                double subtotal = 0;
                                double discount = 0;
                                while (em.hasMoreElements()) {
                                    String key = em.nextElement().toString();
                                    if(key!="login" && key!="admin"){
                                    Productitem pro = (Productitem) session.getAttribute(key);
                            %>
                            <tr>
                                <td>
                                    <div class="d-flex w-100" style="margin-left: 20px;height:155px;overflow: hidden;">
                                        <img 
                                                src="<%=pro.getImage()%>"
                                                alt=""
                                                /> 
                                    </div>                                                                                  
                                </td>
                                <td>
                                    <div class="media-body">
                                        <p><%=pro.getProductName()%></p>
                                    </div>
                                </td>
                                <td>
                                    <h5><%=pro.getPrice()%></h5>
                                </td>
                        <form id="<%=pro.getProductID()%>" action="ControllerAddtoCart?do=updateQuantity" method="post">
                            <td>
                                <div class="product_count">                         
                                    <input type="hidden" name="pid" value="<%=pro.getProductID()%>">                                            
                                    <input class="quantity" onchange="document.getElementById('<%=pro.getProductID()%>').submit()" name="updateQuantity" type="number" value="<%=pro.getQuantity()%>">
                                </div>
                            </td>
                        </form>
                        <td>
                            <h5><%=pro.getPrice() * pro.getQuantity()%></h5>
                        </td>
                        <form action="ControllerAddtoCart?do=deleteCart" method="post">
                            <input type="hidden" name="pid" value="<%=pro.getProductID()%>">
                            <td>
                                <a href="ControllerAddtoCart?do=deleteCart&pid=<%=pro.getProductID()%>" type="submit" class="delete-Pro">
                                    <i class="ti-trash"></i></button>
                                </a>  
                            </td>                    
                        </form>
                </tr>    
                <%subtotal += pro.getPrice() * pro.getQuantity();
                    }}%>

                <tr class="bottom_button">
                    <td>
                        <a class="gray_btn" href="#"></a>
                    </td>
                    <td>                     
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="ControllerAddtoCart?do=deleteAllCart" class="delete-All">
                            <i class="ti-trash"></i>
                        </a>
                        <span>Delete All</span>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <h5>Subtotal</h5>
                    </td>
                    <td>
                        <h5>$<%=subtotal%></h5>
                    </td>
                </tr>
                <tr class="shipping_area">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <h5>Discount:</h5>
                    </td>
                    <td>
                        <div class="shipping_box">
                            <ul class="list">
                                <li>
                                    <%if (subtotal > 100 && subtotal < 200) {
                                            discount = subtotal * 0.1;
                                        }
                                        if (subtotal > 200 && subtotal < 300) {
                                            discount = subtotal *0.13;
                                        }
                                        if (subtotal > 300 && subtotal < 400) {
                                            discount =subtotal *0.18;
                                        }
                                        if (subtotal > 400) {
                                            discount =subtotal * 0.25;
                                        }
                                        if (subtotal < 100) {
                                            discount = 0;
                                        }
                                    %>
                                    <a href="#">$<%=discount%></a>
                                </li>
                            </ul>
                        </div>
                    </td>
                </tr>
                <tr class="out_button_area">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <div class="checkout_btn_inner">
                            <a class="gray_btn" href="ControllerAddtoCart?do=listAllProduct">Continue Shopping</a>
                            <a class="main_btn" href="ControllerAddtoCart?do=Checkout&discount=<%=discount%>">checkout</a>
                        </div>
                    </td>
                </tr>
                </tbody>
                </table>
            </div>
        </div>
    </div>
</section>
<!--================End Cart Area =================-->

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
<script src="js/mail-script.js"></script>
<script src="vendors/jquery-ui/jquery-ui.js"></script>
<script src="vendors/counter-up/jquery.waypoints.min.js"></script>
<script src="vendors/counter-up/jquery.counterup.js"></script>
<script src="js/theme.js"></script>
</body>
</html>
