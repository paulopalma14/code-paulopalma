<?php





require_once 'Controllers/loadControl.php';

$cont = new \mineiro\loadControl();


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Daily Shop | Home</title>

    <!-- Font awesome -->
    <link href="View/css/font-awesome.css" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="View/css/bootstrap.css" rel="stylesheet">
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="View/css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="View/css/jquery.simpleLens.css">
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="View/css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="View/css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="View/css/theme-color/default-theme.css" rel="stylesheet">
    <!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
    <!-- Top Slider CSS -->
    <link href="View/css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link href="View/css/style.css" rel="stylesheet">

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<a class="scrollToTop" href="#"><i class="fa fa-chevron-up"></i></a>

<header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-top-area">
                        <!-- start header top left -->
                        <div class="aa-header-top-left">
                        </div>
                        <!-- / header top left -->
                        <div class="aa-header-top-right">
                            <ul class="aa-head-top-nav-right">
                                <li class="hidden-xs"><a href="account.php">Registar</a></li>
                                <li><a href="" data-toggle="modal" data-target="#login-modal">Login</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="aa-header-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-bottom-area">
                        <div class="aa-logo">
                            <a href="index.php"><img src="View/img/logo_mineiro.png" alt="logo img"></a>
                        </div>
                        <div class="aa-cartbox">
                            <a class="aa-cart-link" href="#">
                                <span class="fa fa-shopping-basket"></span>
                                <span class="aa-cart-title">Carrinho</span>
                                <?php
                                    $cont->cartQtyMenu() ;
                                ?>
                            </a>
                        </div>
                        <div class="aa-search-box">
                            <form action="">
                                <input type="text" name="" id="" placeholder="Procure aqui ex.'homem'">
                                <button type="submit"><span class="fa fa-search"></span></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header bottom  -->
</header>

<!-- menu -->
<section id="menu">
    <div class="container">
        <div class="menu-area">
            <!-- Navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="navbar-collapse collapse">
                    <!-- Left nav -->
                    <ul class="nav navbar-nav">
                        <li><a href="index.php">Home</a></li>
                        <li><a href="#">Equipamentos 16/17<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="product.php?type=1">Camisolas</a></li>
                                <li><a href="product.php?type=2">Calsões</a></li>
                                <li><a href="product.php?type=3">Meias</a></li>
                                <li><a href="product.php?type=5">BoxSet's Bébé/ Criança</a></li>
                                <li><a href="product.php?type=6">Treino</a></li>
                                <li><a href="product.php?type=7">Saída</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Mulher <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Kurta & Kurti</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Bebé/Criança <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="product.php?type=8">Acessórios</a></li>
                                <li><a href="product.php?type=9">Equipamentos</a></li>
                                <li><a href="product.php?type=10">Peluches</a></li>
                                <li><a href="product.php?type=11">Vestuário</a></li>
                                <li><a href="#">Brinquedos</a></li>
                                <li><a href="product.php?type=12">Calçado</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Diversos <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="product.php?type=13">Bolas</a></li>
                                <li><a href="product.php?type=14">Cachecóis</a></li>
                                <li><a href="product.php?type=15">Carteiras</a></li>
                                <li><a href="product.php?type=16">Home</a></li>
                                <li><a href="product.php?type=17">Mochilas/Malas</a></li>
                                <li><a href="product.php?type=18">Porta-Chaves</a></li>
                                <li><a href="#">Regresso Às Aulas</a> </li>
                            </ul>
                        </li>
                        <li><a href="#">Bilheteira</a></li>
                        <li><a href="#">Promoções <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Kurta & Kurti</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.php">Contactos</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
