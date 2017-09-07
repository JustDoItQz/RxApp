<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="../plugins/images/favicon.png">
    <title>Ample Admin Template - The Ultimate Multipurpose admin template</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="../plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- page CSS -->
    <link href="../plugins/bower_components/bootstrap-datepicker/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css" />
    <link href="../plugins/bower_components/custom-select/custom-select.css" rel="stylesheet" type="text/css" />
    <link href="../plugins/bower_components/switchery/dist/switchery.min.css" rel="stylesheet" />
    <link href="../plugins/bower_components/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
    <link href="../plugins/bower_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet" />
    <link href="../plugins/bower_components/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
    <link href="../plugins/bower_components/multiselect/css/multi-select.css" rel="stylesheet" type="text/css" />
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header">
    <!-- ============================================================== -->
    <!-- Preloader -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <div class="top-left-part">
                    <!-- Logo -->
                    <a class="logo" href="index.html">
                        <!-- Logo icon image, you can use font-icon also --><b>
                        <!--This is dark logo icon--><img src="../plugins/images/admin-logo.png" alt="home" class="dark-logo" /><!--This is light logo icon--><img src="../plugins/images/admin-logo-dark.png" alt="home" class="light-logo" />
                     </b>
                        <!-- Logo text image you can use text also --><span class="hidden-xs">
                        <!--This is dark logo text--><img src="../plugins/images/admin-text.png" alt="home" class="dark-logo" /><!--This is light logo text--><img src="../plugins/images/admin-text-dark.png" alt="home" class="light-logo" />
                     </span> </a>
                </div>
                <!-- /Logo -->
                <!-- Search input and Toggle icon -->
                <ul class="nav navbar-top-links navbar-left">
                    <li><a href="javascript:void(0)" class="open-close waves-effect waves-light visible-xs"><i class="ti-close ti-menu"></i></a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="#"> <i class="mdi mdi-gmail"></i>
                            <div class="notify"> <span class="heartbit"></span> <span class="point"></span> </div>
                        </a>
                        <ul class="dropdown-menu mailbox animated bounceInDown">
                            <li>
                                <div class="drop-title">You have 4 new messages</div>
                            </li>
                            <li>
                                <div class="message-center">
                                    <a href="#">
                                        <div class="user-img"> <img src="../plugins/images/users/pawandeep.jpg" alt="user" class="img-circle"> <span class="profile-status online pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:30 AM</span> </div>
                                    </a>
                                    <a href="#">
                                        <div class="user-img"> <img src="../plugins/images/users/sonu.jpg" alt="user" class="img-circle"> <span class="profile-status busy pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Sonu Nigam</h5> <span class="mail-desc">I've sung a song! See you at</span> <span class="time">9:10 AM</span> </div>
                                    </a>
                                    <a href="#">
                                        <div class="user-img"> <img src="../plugins/images/users/arijit.jpg" alt="user" class="img-circle"> <span class="profile-status away pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Arijit Sinh</h5> <span class="mail-desc">I am a singer!</span> <span class="time">9:08 AM</span> </div>
                                    </a>
                                    <a href="#">
                                        <div class="user-img"> <img src="../plugins/images/users/pawandeep.jpg" alt="user" class="img-circle"> <span class="profile-status offline pull-right"></span> </div>
                                        <div class="mail-contnet">
                                            <h5>Pavan kumar</h5> <span class="mail-desc">Just see the my admin!</span> <span class="time">9:02 AM</span> </div>
                                    </a>
                                </div>
                            </li>
                            <li>
                                <a class="text-center" href="javascript:void(0);"> <strong>See all notifications</strong> <i class="fa fa-angle-right"></i> </a>
                            </li>
                        </ul>
                        <!-- /.dropdown-messages -->
                    </li>
                    <!-- .Task dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="#"> <i class="mdi mdi-check-circle"></i>
                            <div class="notify"><span class="heartbit"></span><span class="point"></span></div>
                        </a>
                        <ul class="dropdown-menu dropdown-tasks animated slideInUp">
                            <li>
                                <a href="#">
                                    <div>
                                        <p> <strong>Task 1</strong> <span class="pull-right text-muted">40% Complete</span> </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span class="sr-only">40% Complete (success)</span> </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p> <strong>Task 2</strong> <span class="pull-right text-muted">20% Complete</span> </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%"> <span class="sr-only">20% Complete</span> </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p> <strong>Task 3</strong> <span class="pull-right text-muted">60% Complete</span> </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%"> <span class="sr-only">60% Complete (warning)</span> </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p> <strong>Task 4</strong> <span class="pull-right text-muted">80% Complete</span> </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%"> <span class="sr-only">80% Complete (danger)</span> </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#"> <strong>See All Tasks</strong> <i class="fa fa-angle-right"></i> </a>
                            </li>
                        </ul>
                    </li>
                    <!-- .Megamenu -->
                    <li class="mega-dropdown"> <a class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" href="#"><span class="hidden-xs">Mega</span> <i class="icon-options-vertical"></i></a>
                        <ul class="dropdown-menu mega-dropdown-menu animated bounceInDown">
                            <li class="col-sm-3">
                                <ul>
                                    <li class="dropdown-header">Forms Elements</li>
                                    <li><a href="form-basic.html">Basic Forms</a></li>
                                    <li><a href="form-layout.html">Form Layout</a></li>
                                    <li><a href="form-advanced.html">Form Addons</a></li>
                                    <li><a href="form-material-elements.html">Form Material</a></li>
                                    <li><a href="form-float-input.html">Form Float Input</a></li>
                                    <li><a href="form-upload.html">File Upload</a></li>
                                    <li><a href="form-mask.html">Form Mask</a></li>
                                    <li><a href="form-img-cropper.html">Image Cropping</a></li>
                                    <li><a href="form-validation.html">Form Validation</a></li>
                                </ul>
                            </li>
                            <li class="col-sm-3">
                                <ul>
                                    <li class="dropdown-header">Advance Forms</li>
                                    <li><a href="form-dropzone.html">File Dropzone</a></li>
                                    <li><a href="form-pickers.html">Form-pickers</a></li>
                                    <li><a href="form-wizard.html">Form-wizards</a></li>
                                    <li><a href="form-typehead.html">Typehead</a></li>
                                    <li><a href="form-xeditable.html">X-editable</a></li>
                                    <li><a href="form-summernote.html">Summernote</a></li>
                                    <li><a href="form-bootstrap-wysihtml5.html">Bootstrap wysihtml5</a></li>
                                    <li><a href="form-tinymce-wysihtml5.html">Tinymce wysihtml5</a></li>
                                </ul>
                            </li>
                            <li class="col-sm-3">
                                <ul>
                                    <li class="dropdown-header">Table Example</li>
                                    <li><a href="basic-table.html">Basic Tables</a></li>
                                    <li><a href="table-layouts.html">Table Layouts</a></li>
                                    <li><a href="data-table.html">Data Table</a></li>
                                    <li><a href="bootstrap-tables.html">Bootstrap Tables</a></li>
                                    <li><a href="responsive-tables.html">Responsive Tables</a></li>
                                    <li><a href="editable-tables.html">Editable Tables</a></li>
                                    <li><a href="foo-tables.html">FooTables</a></li>
                                    <li><a href="jsgrid.html">JsGrid Tables</a></li>
                                </ul>
                            </li>
                            <li class="col-sm-3">
                                <ul>
                                    <li class="dropdown-header">Charts</li>
                                    <li> <a href="flot.html">Flot Charts</a> </li>
                                    <li><a href="morris-chart.html">Morris Chart</a></li>
                                    <li><a href="chart-js.html">Chart-js</a></li>
                                    <li><a href="peity-chart.html">Peity Charts</a></li>
                                    <li><a href="knob-chart.html">Knob Charts</a></li>
                                    <li><a href="sparkline-chart.html">Sparkline charts</a></li>
                                    <li><a href="extra-charts.html">Extra Charts</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <!-- /.Megamenu -->
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i class="fa fa-search"></i></a> </form>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle profile-pic" data-toggle="dropdown" href="#"> <img src="../plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle"><b class="hidden-xs">Steave</b><span class="caret"></span> </a>
                        <ul class="dropdown-menu dropdown-user animated flipInY">
                            <li>
                                <div class="dw-user-box">
                                    <div class="u-img"><img src="../plugins/images/users/varun.jpg" alt="user" /></div>
                                    <div class="u-text">
                                        <h4>Steave Jobs</h4>
                                        <p class="text-muted">varun@gmail.com</p><a href="profile.html" class="btn btn-rounded btn-danger btn-sm">View Profile</a></div>
                                </div>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="ti-user"></i> My Profile</a></li>
                            <li><a href="#"><i class="ti-wallet"></i> My Balance</a></li>
                            <li><a href="#"><i class="ti-email"></i> Inbox</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="ti-settings"></i> Account Setting</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#"><i class="fa fa-power-off"></i> Logout</a></li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- End Top Navigation -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-menu hidden-xs"></i><i class="ti-close visible-xs"></i></span> <span class="hide-menu">Navigation</span></h3> </div>
                <ul class="nav" id="side-menu">
                    <li class="user-pro">
                        <a href="#" class="waves-effect"><img src="../plugins/images/users/varun.jpg" alt="user-img" class="img-circle"> <span class="hide-menu"> Steve Gection<span class="fa arrow"></span></span>
                        </a>
                        <ul class="nav nav-second-level collapse" aria-expanded="false" style="height: 0px;">
                            <li><a href="javascript:void(0)"><i class="ti-user"></i> <span class="hide-menu">My Profile</span></a></li>
                            <li><a href="javascript:void(0)"><i class="ti-wallet"></i> <span class="hide-menu">My Balance</span></a></li>
                            <li><a href="javascript:void(0)"><i class="ti-email"></i> <span class="hide-menu">Inbox</span></a></li>
                            <li><a href="javascript:void(0)"><i class="ti-settings"></i> <span class="hide-menu">Account Setting</span></a></li>
                            <li><a href="javascript:void(0)"><i class="fa fa-power-off"></i> <span class="hide-menu">Logout</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="index.html" class="waves-effect"><i class="mdi mdi-av-timer fa-fw" data-icon="v"></i> <span class="hide-menu"> Dashboard <span class="fa arrow"></span> <span class="label label-rouded label-inverse pull-right">4</span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="index.html"><i class=" fa-fw">1</i><span class="hide-menu">Dashboard 1</span></a> </li>
                            <li> <a href="index2.html"><i class=" fa-fw">2</i><span class="hide-menu">Dashboard 2</span></a> </li>
                            <li> <a href="index3.html"><i class=" fa-fw">3</i><span class="hide-menu">Dashboard 3</span></a> </li>
                        </ul>
                    </li>
                    <li> <a href="#" class="waves-effect"><i class="mdi mdi-format-color-fill fa-fw"></i> <span class="hide-menu">UI Elements<span class="fa arrow"></span> <span class="label label-rouded label-info pull-right">20</span> </span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="panels-wells.html"><i data-icon="&#xe026;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Panels and Wells</span></a></li>
                            <li><a href="panel-ui-block.html"><i data-icon="&#xe025;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Panels With BlockUI</span></a></li>
                            <li><a href="buttons.html"><i class="ti-layout-menu fa-fw"></i> <span class="hide-menu">Buttons</span></a></li>
                            <li><a href="sweatalert.html"><i class="ti-alert fa-fw"></i> <span class="hide-menu">Sweat alert</span></a></li>
                            <li><a href="typography.jsp"><i data-icon="k" class="linea-icon linea-software fa-fw"></i> <span class="hide-menu">Typography</span></a></li>
                            <li><a href="grid.html"><i data-icon="&#xe009;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Grid</span></a></li>
                            <li><a href="tabs.html"><i  class="ti-layers fa-fw"></i> <span class="hide-menu">Tabs</span></a></li>
                            <li><a href="tab-stylish.html"><i class=" ti-layers-alt fa-fw"></i> <span class="hide-menu">Stylish Tabs</span></a></li>
                            <li><a href="modals.html"><i data-icon="&#xe026;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Modals</span></a></li>
                            <li><a href="progressbars.html"><i class="ti-line-double fa-fw"></i> <span class="hide-menu">Progress Bars</span></a></li>
                            <li><a href="notification.html"><i class="ti-info-alt fa-fw"></i> <span class="hide-menu">Notifications</span></a></li>
                            <li><a href="carousel.html"><i class="ti-layout-slider fa-fw"></i> <span class="hide-menu">Carousel</span></a></li>
                            <li><a href="list-style.html"><i data-icon="&#xe00b;" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">List & Media object</span></a></li>
                            <li><a href="user-cards.jsp"><i class="ti-user fa-fw"></i> <span class="hide-menu">User Cards</span></a></li>
                            <li><a href="timeline.html"><i data-icon="/" class="linea-icon linea-basic fa-fw"></i> <span class="hide-menu">Timeline</span></a></li>
                            <li><a href="timeline-horizontal.html"><i class="ti-layout-list-thumb fa-fw"></i> <span class="hide-menu">Horizontal Timeline</span></a></li>
                            <li><a href="nestable.html"><i class="ti-layout-accordion-separated fa-fw"></i> <span class="hide-menu">Nesteble</span></a></li>
                            <li><a href="range-slider.html"><i class=" ti-layout-slider-alt fa-fw"></i> <span class="hide-menu">Range Slider</span></a></li>
                            <li><a href="tooltip-stylish.html"><i class="ti-comments-smiley fa-fw"></i> <span class="hide-menu">Stylish Tooltip</span></a></li>
                            <li><a href="bootstrap.html"><i class="ti-rocket fa-fw"></i> <span class="hide-menu">Bootstrap UI</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="#" class="waves-effect"><i class="mdi mdi-content-copy fa-fw"></i> <span class="hide-menu">Sample Pages<span class="fa arrow"></span><span class="label label-rouded label-warning pull-right">30</span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="starter-page.html"><i class="ti-layout-width-default fa-fw"></i> <span class="hide-menu">Starter Page</span></a></li>
                            <li><a href="blank.html"><i class="ti-layout-sidebar-left fa-fw"></i> <span class="hide-menu">Blank Page</span></a></li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-email fa-fw"></i> <span class="hide-menu">Email Templates</span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="../email-templates/basic.html"><i class="fa-fw">B</i> <span class="hide-menu">Basic</span></a></li>
                                    <li> <a href="../email-templates/alert.html"><i class="ti-alert fa-fw"></i> <span class="hide-menu">Alert</span></a></li>
                                    <li> <a href="../email-templates/billing.html"><i class="ti-wallet fa-fw"></i> <span class="hide-menu">Billing</span></a></li>
                                    <li> <a href="../email-templates/password-reset.html"><i class="ti-more fa-fw"></i> <span class="hide-menu">Reset Pwd</span></a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-lock fa-fw"></i><span class="hide-menu">Authentication</span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li><a href="login.html"><i class="fa-fw">L</i> <span class="hide-menu">Login Page</span></a></li>
                                    <li><a href="login2.html"><i class="fa-fw">L</i> <span class="hide-menu">Login v2</span></a></li>
                                    <li><a href="register.html"><i class="fa-fw">R</i> <span class="hide-menu">Register</span></a></li>
                                    <li><a href="register2.html"><i class="fa-fw">R</i> <span class="hide-menu">Register v2</span></a></li>
                                    <li><a href="register3.html"><i class="fa-fw">3</i> <span class="hide-menu">3 Step Registration</span></a></li>
                                    <li><a href="recoverpw.html"><i class="fa-fw">R</i> <span class="hide-menu">Recover Password</span></a></li>
                                    <li><a href="lock-screen.html"><i class="fa-fw">L</i> <span class="hide-menu">Lock Screen</span></a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-info-alt fa-fw"></i><span class="hide-menu">Error Pages</span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li><a href="400.jsp"><i class="ti-info-alt fa-fw"></i> <span class="hide-menu">Error 400</span></a></li>
                                    <li><a href="403.jsp"><i class="ti-info-alt fa-fw"></i> <span class="hide-menu">Error 403</span></a></li>
                                    <li><a href="404.html"><i class="ti-info-alt fa-fw"></i> <span class="hide-menu">Error 404</span></a></li>
                                    <li><a href="500.html"><i class="ti-info-alt fa-fw"></i> <span class="hide-menu">Error 500</span></a></li>
                                    <li><a href="503.html"><i class="ti-info-alt fa-fw"></i> <span class="hide-menu">Error 503</span></a></li>
                                </ul>
                            </li>
                            <li><a href="lightbox.html"><i class="fa-fw">L</i> <span class="hide-menu">Lightbox Popup</span></a></li>
                            <li><a href="treeview.html"><i class="fa-fw">T</i> <span class="hide-menu">Treeview</span></a></li>
                            <li><a href="search-result.html"><i class="fa-fw">S</i> <span class="hide-menu">Search Result</span></a></li>
                            <li><a href="utility-classes.jsp"><i class="fa-fw">U</i> <span class="hide-menu">Utility Classes</span></a></li>
                            <li><a href="custom-scroll.html"><i class="fa-fw">C</i> <span class="hide-menu">Custom Scrolls</span></a></li>
                            <li><a href="animation.html"><i class="fa-fw">A</i> <span class="hide-menu">Animations</span></a></li>
                            <li><a href="profile.html"><i class="fa-fw">P</i> <span class="hide-menu">Profile</span></a></li>
                            <li><a href="invoice.html"><i class="fa-fw">I</i> <span class="hide-menu">Invoice</span></a></li>
                            <li><a href="faq.html"><i class="fa-fw">F</i> <span class="hide-menu">FAQ</span></a></li>
                            <li><a href="gallery.html"><i class="fa-fw">G</i> <span class="hide-menu">Gallery</span></a></li>
                            <li><a href="pricing.html"><i class="fa-fw">P</i> <span class="hide-menu">Pricing</span></a></li>
                        </ul>
                    </li>
                    <li><a href="inbox.html" class="waves-effect"><i class="mdi mdi-apps fa-fw"></i> <span class="hide-menu">Apps<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="chat.html"><i class="ti-comments-smiley fa-fw"></i><span class="hide-menu">Chat-message</span></a></li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-desktop fa-fw"></i><span class="hide-menu">Inbox</span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="inbox.html"><i class="ti-email fa-fw"></i><span class="hide-menu">Mail box</span></a></li>
                                    <li> <a href="inbox-detail.html"><i class="ti-layout-media-left-alt fa-fw"></i><span class="hide-menu">Inbox detail</span></a></li>
                                    <li> <a href="compose.html"><i class="ti-layout-media-center-alt fa-fw"></i><span class="hide-menu">Compose mail</span></a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0)" class="waves-effect"><i class="ti-user fa-fw"></i><span class="hide-menu">Contacts</span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="contact.html"><i class="icon-people fa-fw"></i><span class="hide-menu">Contact1</span></a></li>
                                    <li> <a href="contact2.html"><i class="icon-user-follow fa-fw"></i><span class="hide-menu">Contact2</span></a></li>
                                    <li> <a href="contact-detail.html"><i class="icon-user-following fa-fw"></i><span class="hide-menu">Contact Detail</span></a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="devider"></li>
                    <li> <a href="forms.html" class="waves-effect active"><i class="mdi mdi-clipboard-text fa-fw"></i> <span class="hide-menu">Forms<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="form-basic.html"><i class="fa-fw">B</i><span class="hide-menu">Basic Forms</span></a></li>
                            <li><a href="form-layout.html"><i class="fa-fw">L</i><span class="hide-menu">Form Layout</span></a></li>
                            <li><a href="form-advanced.html"><i class="fa-fw">A</i><span class="hide-menu">Form Addons</span></a></li>
                            <li><a href="form-material-elements.html"><i class="fa-fw">M</i><span class="hide-menu">Form Material</span></a></li>
                            <li><a href="form-float-input.html"><i class="fa-fw">F</i><span class="hide-menu">Form Float Input</span></a></li>
                            <li><a href="form-upload.html"><i class="fa-fw">U</i><span class="hide-menu">File Upload</span></a></li>
                            <li><a href="form-mask.html"><i class="fa-fw">M</i><span class="hide-menu">Form Mask</span></a></li>
                            <li><a href="form-img-cropper.html"><i class="fa-fw">C</i><span class="hide-menu">Image Cropping</span></a></li>
                            <li><a href="form-validation.html"><i class="fa-fw">V</i><span class="hide-menu">Form Validation</span></a></li>
                            <li><a href="form-dropzone.html"><i class="fa-fw">D</i><span class="hide-menu">File Dropzone</span></a></li>
                            <li><a href="form-pickers.html"><i class="fa-fw">P</i><span class="hide-menu">Form-pickers</span></a></li>
                            <li><a href="form-wizard.html"><i class="fa-fw">W</i><span class="hide-menu">Form-wizards</span></a></li>
                            <li><a href="form-typehead.html"><i class="fa-fw">T</i><span class="hide-menu">Typehead</span></a></li>
                            <li><a href="form-xeditable.html"><i class="fa-fw">X</i><span class="hide-menu">X-editable</span></a></li>
                            <li><a href="form-summernote.html"><i class="fa-fw">S</i><span class="hide-menu">Summernote</span></a></li>
                            <li><a href="form-bootstrap-wysihtml5.html"><i class=" fa-fw">W</i><span class="hide-menu">Bootstrap wysihtml5</span></a></li>
                            <li><a href="form-tinymce-wysihtml5.html"><i class="fa-fw">T</i><span class="hide-menu">Tinymce wysihtml5</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="tables.html" class="waves-effect"><i class="mdi mdi-table fa-fw"></i> <span class="hide-menu">Tables<span class="fa arrow"></span><span class="label label-rouded label-danger pull-right">9</span></span></a>
                        <ul class="nav nav-second-level">
                            <li><a href="basic-table.html"><i class="fa-fw">B</i><span class="hide-menu">Basic Tables</span></a></li>
                            <li><a href="table-layouts.html"><i class="fa-fw">L</i><span class="hide-menu">Table Layouts</span></a></li>
                            <li><a href="data-table.html"><i class="fa-fw">D</i><span class="hide-menu">Data Table</span></a></li>
                            <li><a href="bootstrap-tables.html"><i class="fa-fw">B</i><span class="hide-menu">Bootstrap Tables</span></a></li>
                            <li><a href="responsive-tables.html"><i class="fa-fw">R</i><span class="hide-menu">Responsive Tables</span></a></li>
                            <li><a href="editable-tables.html"><i class="fa-fw">E</i><span class="hide-menu">Editable Tables</span></a></li>
                            <li><a href="foo-tables.html"><i class="fa-fw">F</i><span class="hide-menu">FooTables</span></a></li>
                            <li><a href="jsgrid.html"><i class="fa-fw">J</i><span class="hide-menu">JsGrid Tables</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="#" class="waves-effect"><i class="mdi mdi-chart-bar fa-fw"></i> <span class="hide-menu">Charts<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="flot.html"><i class="fa-fw">F</i><span class="hide-menu">Flot Charts</span></a> </li>
                            <li><a href="morris-chart.html"><i class="fa-fw">M</i><span class="hide-menu">Morris Chart</span></a></li>
                            <li><a href="chart-js.html"><i class="fa-fw">P</i><span class="hide-menu">Chart-js</span></a></li>
                            <li><a href="peity-chart.html"><i class="fa-fw">P</i><span class="hide-menu">Peity Charts</span></a></li>
                            <li><a href="chartist-js.html"><i class="fa-fw">C</i><span class="hide-menu">Chartist-js</span></a></li>
                            <li><a href="knob-chart.html"><i class="fa-fw">K</i><span class="hide-menu">Knob Charts</span></a></li>
                            <li><a href="sparkline-chart.html"><i class="fa-fw">S</i><span class="hide-menu">Sparkline charts</span></a></li>
                            <li><a href="extra-charts.html"><i class="fa-fw">E</i><span class="hide-menu">Extra Charts</span></a></li>
                        </ul>
                    </li>
                    <li class="devider"></li>
                    <li> <a href="widgets.jsp" class="waves-effect"><i class="mdi mdi-settings fa-fw"></i> <span class="hide-menu">Widgets</span></a> </li>
                    <li> <a href="#" class="waves-effect"><i class="mdi mdi-emoticon fa-fw"></i> <span class="hide-menu">Icons<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="fontawesome.html"><i class="fa-fw">F</i><span class="hide-menu">Font awesome</span></a> </li>
                            <li> <a href="themifyicon.html"><i class="fa-fw">T</i><span class="hide-menu">Themify Icons</span></a> </li>
                            <li> <a href="simple-line.html"><i class="fa-fw">S</i><span class="hide-menu">Simple line Icons</span></a> </li>
                            <li> <a href="material-icons.html"><i class="fa-fw">M</i><span class="hide-menu">Material Icons</span></a> </li>
                            <li><a href="linea-icon.html"><i class="fa-fw">L</i><span class="hide-menu">Linea Icons</span></a></li>
                            <li><a href="weather.jsp"><i class="fa-fw">W</i><span class="hide-menu">Weather Icons</span></a></li>
                        </ul>
                    </li>
                    <li> <a href="map-google.html" class="waves-effect"><i class="mdi mdi-google-maps fa-fw"></i><span class="hide-menu">Google Map</span></a> </li>
                    <li> <a href="map-vector.html" class="waves-effect"><i class="mdi mdi-map-marker fa-fw"></i><span class="hide-menu">Vector Map</span></a> </li>
                    <li> <a href="calendar.html" class="waves-effect"><i class="mdi mdi-calendar-check fa-fw"></i> <span class="hide-menu">Calendar</span></a></li>
                    <li> <a href="javascript:void(0)" class="waves-effect"><i class="mdi mdi-checkbox-multiple-marked-outline fa-fw"></i> <span class="hide-menu">Multi-Level Dropdown<span class="fa arrow"></span></span></a>
                        <ul class="nav nav-second-level">
                            <li> <a href="javascript:void(0)"><i data-icon="/" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu">Second Level Item</span></a> </li>
                            <li> <a href="javascript:void(0)"><i data-icon="7" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu">Second Level Item</span></a> </li>
                            <li> <a href="javascript:void(0)" class="waves-effect"><i data-icon="&#xe008;" class="linea-icon linea-basic fa-fw"></i><span class="hide-menu">Third Level </span><span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li> <a href="javascript:void(0)"><i class=" fa-fw">T</i><span class="hide-menu">Third Level Item</span></a> </li>
                                    <li> <a href="javascript:void(0)"><i class=" fa-fw">M</i><span class="hide-menu">Third Level Item</span></a> </li>
                                    <li> <a href="javascript:void(0)"><i class=" fa-fw">R</i><span class="hide-menu">Third Level Item</span></a> </li>
                                    <li> <a href="javascript:void(0)"><i class=" fa-fw">G</i><span class="hide-menu">Third Level Item</span></a> </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="login.html" class="waves-effect"><i class="mdi mdi-logout fa-fw"></i> <span class="hide-menu">Log out</span></a></li>
                    <li class="devider"></li>
                    <li><a href="documentation.html" class="waves-effect"><i class="fa fa-circle-o text-danger"></i> <span class="hide-menu">Documentation</span></a></li>
                    <li><a href="gallery.html" class="waves-effect"><i class="fa fa-circle-o text-info"></i> <span class="hide-menu">Gallery</span></a></li>
                    <li><a href="faq.html" class="waves-effect"><i class="fa fa-circle-o text-success"></i> <span class="hide-menu">Faqs</span></a></li>
                </ul>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- End Left Sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page Content -->
        <!-- ============================================================== -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Form Addons</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <button class="right-side-toggle waves-effect waves-light btn-info btn-circle pull-right m-l-20"><i class="ti-settings text-white"></i></button>
                        <a href="javascript: void(0);" target="_blank" class="btn btn-danger pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">Buy Admin Now</a>
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Forms</a></li>
                            <li class="active">Form Addons</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- .row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title m-b-0">Select 2</h3>
                            <p class="text-muted m-b-30"> Select2 for custom search and select</p>
                            <h5 class="m-t-30">Single select2</h5>
                            <select class="form-control select2">
                                <option>Select</option>
                                <optgroup label="Alaskan/Hawaiian Time Zone">
                                    <option value="AK">Alaska</option>
                                    <option value="HI">Hawaii</option>
                                </optgroup>
                                <optgroup label="Pacific Time Zone">
                                    <option value="CA">California</option>
                                    <option value="NV">Nevada</option>
                                    <option value="OR">Oregon</option>
                                    <option value="WA">Washington</option>
                                </optgroup>
                                <optgroup label="Mountain Time Zone">
                                    <option value="AZ">Arizona</option>
                                    <option value="CO">Colorado</option>
                                    <option value="ID">Idaho</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="UT">Utah</option>
                                    <option value="WY">Wyoming</option>
                                </optgroup>
                                <optgroup label="Central Time Zone">
                                    <option value="AL">Alabama</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TX">Texas</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="WI">Wisconsin</option>
                                </optgroup>
                                <optgroup label="Eastern Time Zone">
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="IN">Indiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="OH">Ohio</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WV">West Virginia</option>
                                </optgroup>
                            </select>
                            <h5 class="m-t-20">Multiple select boxes</h5>
                            <select class="select2 m-b-10 select2-multiple" multiple="multiple" data-placeholder="Choose">
                                <optgroup label="Alaskan/Hawaiian Time Zone">
                                    <option value="AK">Alaska</option>
                                    <option value="HI">Hawaii</option>
                                </optgroup>
                                <optgroup label="Pacific Time Zone">
                                    <option value="CA">California</option>
                                    <option value="NV">Nevada</option>
                                    <option value="OR">Oregon</option>
                                    <option value="WA">Washington</option>
                                </optgroup>
                                <optgroup label="Mountain Time Zone">
                                    <option value="AZ">Arizona</option>
                                    <option value="CO">Colorado</option>
                                    <option value="ID">Idaho</option>
                                    <option value="MT">Montana</option>
                                    <option value="NE">Nebraska</option>
                                    <option value="NM">New Mexico</option>
                                    <option value="ND">North Dakota</option>
                                    <option value="UT">Utah</option>
                                    <option value="WY">Wyoming</option>
                                </optgroup>
                                <optgroup label="Central Time Zone">
                                    <option value="AL">Alabama</option>
                                    <option value="AR">Arkansas</option>
                                    <option value="IL">Illinois</option>
                                    <option value="IA">Iowa</option>
                                    <option value="KS">Kansas</option>
                                    <option value="KY">Kentucky</option>
                                    <option value="LA">Louisiana</option>
                                    <option value="MN">Minnesota</option>
                                    <option value="MS">Mississippi</option>
                                    <option value="MO">Missouri</option>
                                    <option value="OK">Oklahoma</option>
                                    <option value="SD">South Dakota</option>
                                    <option value="TX">Texas</option>
                                    <option value="TN">Tennessee</option>
                                    <option value="WI">Wisconsin</option>
                                </optgroup>
                                <optgroup label="Eastern Time Zone">
                                    <option value="CT">Connecticut</option>
                                    <option value="DE">Delaware</option>
                                    <option value="FL">Florida</option>
                                    <option value="GA">Georgia</option>
                                    <option value="IN">Indiana</option>
                                    <option value="ME">Maine</option>
                                    <option value="MD">Maryland</option>
                                    <option value="MA">Massachusetts</option>
                                    <option value="MI">Michigan</option>
                                    <option value="NH">New Hampshire</option>
                                    <option value="NJ">New Jersey</option>
                                    <option value="NY">New York</option>
                                    <option value="NC">North Carolina</option>
                                    <option value="OH">Ohio</option>
                                    <option value="PA">Pennsylvania</option>
                                    <option value="RI">Rhode Island</option>
                                    <option value="SC">South Carolina</option>
                                    <option value="VT">Vermont</option>
                                    <option value="VA">Virginia</option>
                                    <option value="WV">West Virginia</option>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title m-b-0">Bootstrap Select boxes</h3>
                            <p class="text-muted m-b-10">Just add bootstrap-select-min.js and same css & add class <code>.selectpicker</code></p>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5 class="m-t-30 m-b-10">Select box</h5>
                                    <select class="selectpicker" data-style="form-control">
                                        <option>Mustard</option>
                                        <option>Ketchup</option>
                                        <option>Relish</option>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <h5 class="m-t-30 m-b-10">Select boxes with optgroups</h5>
                                    <select class="selectpicker" data-style="form-control">
                                        <optgroup label="Picnic">
                                            <option>Mustard</option>
                                            <option>Ketchup</option>
                                            <option>Relish</option>
                                        </optgroup>
                                        <optgroup label="Camping">
                                            <option>Tent</option>
                                            <option>Flashlight</option>
                                            <option>Toilet Paper</option>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="col-md-4">
                                    <h5 class="m-t-30">Multiple select boxes</h5>
                                    <select class="selectpicker" multiple data-style="form-control">
                                        <option>Mustard</option>
                                        <option>Ketchup</option>
                                        <option>Relish</option>
                                    </select>
                                </div>
                            </div>
                            <h5 class="m-t-30">With colored Button Classes</h5>
                            <div class="row">
                                <div class="col-sm-4">
                                    <select class="selectpicker m-b-20 m-r-10" data-style="btn-primary btn-outline">
                                        <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                        <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                        <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                    </select>
                                </div>
                                <div class="col-sm-4">
                                    <select class="selectpicker m-b-20 m-r-10" data-style="btn-info btn-outline">
                                        <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                        <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                        <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                    </select>
                                </div>
                                <div class="col-sm-4">
                                    <select class="selectpicker m-b-20 m-r-10" data-style="btn-warning btn-outline">
                                        <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                        <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                        <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                    </select>
                                </div>
                                <div class="col-sm-4">
                                    <select class="selectpicker m-b-20 m-r-10" data-style="btn-danger btn-outline">
                                        <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                        <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                        <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                    </select>
                                </div>
                                <div class="col-sm-4">
                                    <select class="selectpicker m-b-20 m-r-10" data-style="btn-success btn-outline">
                                        <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                        <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                        <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                    </select>
                                </div>
                                <div class="col-sm-4">
                                    <select class="selectpicker m-b-20" data-style="btn-default btn-outline">
                                        <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>
                                        <option data-tokens="mustard">Burger, Shake and a Smile</option>
                                        <option data-tokens="frosting">Sugar, Spice and all things nice</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                        <div class="white-box">
                            <h3 class="box-title">Switchery</h3>
                            <div class="row">
                                <div class="col-lg-12">
                                    <h4 class="box-title">Basic</h4>
                                    <p class="text-muted  font-13"> add the following line <code> class="js-switch" data-color="#13dafe"</code> to your input element. </p>
                                    <div class="switchery-demo m-b-30">
                                        <input type="checkbox" checked class="js-switch" data-color="#13dafe" />
                                        <input type="checkbox" checked class="js-switch" data-color="#f96262" />
                                        <input type="checkbox" checked class="js-switch" data-color="#99d683" />
                                        <input type="checkbox" checked class="js-switch" data-color="#ffca4a" />
                                        <input type="checkbox" checked class="js-switch" data-color="#6164c1" />
                                        <input type="checkbox" checked class="js-switch" data-color="#3d3b3b" /> </div>
                                </div>
                                <div class="col-lg-12">
                                    <h4 class="box-title">Sizes</h4>
                                    <p class="text-muted font-13"> You can add <code> data-size="small",data-size="large"</code> to your input element for different sizes. </p>
                                    <div class="m-b-30">
                                        <input type="checkbox" checked class="js-switch" data-color="#f96262" data-size="small" />
                                        <input type="checkbox" checked class="js-switch" data-color="#99d683" />
                                        <input type="checkbox" checked class="js-switch" data-color="#ffca4a" data-size="large" /> </div>
                                </div>
                                <div class="col-lg-12">
                                    <h4 class="box-title">Secondary color</h4>
                                    <p class="text-muted font-13"> You can apply <code> data-color="@color" data-secondary-color="@color"</code> to your input element to both color. </p>
                                    <div class="m-b-30">
                                        <input type="checkbox" class="js-switch" data-color="#99d683" data-secondary-color="#f96262" />
                                        <input type="checkbox" class="js-switch" data-color="#13dafe" data-secondary-color="#6164c1" /> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <div class="white-box">
                            <h3 class="box-title">Input Tags</h3>
                            <p class="text-muted">Add <code>data-role="tagsinput"</code> to your input field & its automatically change it to a tags input.</p>
                            <div class="tags-default">
                                <input type="text" value="Amsterdam,Washington,Sydney" data-role="tagsinput" placeholder="add tags" /> </div>
                            <h3 class="box-title m-t-30 m-b-0">Select Tags</h3>
                            <p class="text-muted">You can also use <code>select multiple</code> to your input field.</p>
                            <select multiple data-role="tagsinput">
                                <option value="Amsterdam">Amsterdam</option>
                                <option value="Washington">Washington</option>
                                <option value="Sydney">Sydney</option>
                            </select>
                            <h3 class="box-title m-t-30 m-b-0">Input Group Tags</h3>
                            <p class="text-muted">You can also use group tag <code>data-role="tagsinput"</code> to your input field.</p>
                            <div class="input-group m-b-30"> <span class="input-group-addon">Tags</span>
                                <input type="text" value="Amsterdam,Washington,Sydney" data-role="tagsinput" placeholder="add tags"> </div>
                            <div class="input-group">
                                <input type="text" value="Amsterdam,Washington,Sydney" data-role="tagsinput" placeholder="add tags"> <span class="input-group-addon">Tags</span> </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="m-b-0 box-title">Bootstrap TouchSpin</h3>
                            <p class="text-muted m-b-40"> Use the <code> data-plugin="touchSpin" </code> to create a Bootstrap style spinner.</p>
                            <div class="row">
                                <div class="col-md-6">
                                    <form class="p-r-20">
                                        <div class="form-group">
                                            <label class="control-label">Vertical Touchspin</label>
                                            <input class="vertical-spin" type="text" data-bts-button-down-class="btn btn-default btn-outline" data-bts-button-up-class="btn btn-default btn-outline" value="" name="vertical-spin"> </div>
                                        <div class="form-group">
                                            <label class="control-label">Postfix</label>
                                            <input id="tch1" type="text" value="55" name="tch1" data-bts-button-down-class="btn btn-default btn-outline" data-bts-button-up-class="btn btn-default btn-outline"> </div>
                                        <div class="form-group m-b-0">
                                            <label class="control-label">Prefix</label>
                                            <input id="tch2" type="text" value="0" name="tch2" class=" form-control" data-bts-button-down-class="btn btn-default btn-outline" data-bts-button-up-class="btn btn-default btn-outline"> </div>
                                    </form>
                                </div>
                                <div class="col-md-6">
                                    <form>
                                        <div class="form-group">
                                            <label class="control-label">Init </label>
                                            <input id="tch3" type="text" value="" name="tch3" data-bts-button-down-class="btn btn-default btn-outline" data-bts-button-up-class="btn btn-default btn-outline"> </div>
                                        <div class="form-group">
                                            <label class="control-label">Value set 30 </label>
                                            <input id="tch3_22" type="text" value="30" name="tch3_22" data-bts-button-down-class="btn btn-default btn-outline" data-bts-button-up-class="btn btn-default btn-outline"> </div>
                                        <div class="form-group m-b-0">
                                            <label class="control-label">Button group</label>
                                            <div class="input-group">
                                                <input id="tch5" type="text" class="form-control" name="tch5" value="50" data-bts-button-down-class="btn btn-default btn-outline" data-bts-button-up-class="btn btn-default btn-outline">
                                                <div class="input-group-btn">
                                                    <button type="button" class="btn btn-default btn-outline dropdown-toggle" data-toggle="dropdown"> <span class="caret"></span> <span class="sr-only">Toggle Dropdown</span> </button>
                                                    <ul class="dropdown-menu pull-right" role="menu">
                                                        <li> <a href="#">Action</a> </li>
                                                        <li> <a href="#">Another action</a> </li>
                                                        <li> <a href="#">Something else here</a> </li>
                                                        <li class="divider"></li>
                                                        <li> <a href="#">Separated link</a> </li>
                                                    </ul>
                                                </div>
                                            </div>
                                    </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                    <!-- .row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="white-box">
                                <h3 class="m-b-0 box-title">Multiple Select</h3>
                                <p class="text-muted m-b-30"> Use a <code>select multiple</code> as your input element.</p>
                                <div class="row">
                                    <div class="col-lg-4 col-sm-6">
                                        <h5 class="box-title">Pre-selected options</h5>
                                        <select id='pre-selected-options' multiple='multiple'>
                                            <option value='elem_1'>elem 1</option>
                                            <option value='elem_2'>elem 2</option>
                                            <option value='elem_3'>elem 3</option>
                                            <option value='elem_4' selected>elem 4</option>
                                            <option value='elem_5' selected>elem 5</option>
                                            <option value="elem_6">elem 6</option>
                                            <option value="elem_7">elem 7</option>
                                            <option value="elem_8">elem 8</option>
                                            <option value="elem_9">elem 9</option>
                                            <option value="elem_10">elem 10</option>
                                            <option value="elem_11">elem 11</option>
                                            <option value="elem_12">elem 12</option>
                                            <option value="elem_13">elem 13</option>
                                            <option value="elem_14">elem 14</option>
                                            <option value="elem_15">elem 15</option>
                                            <option value="elem_16">elem 16</option>
                                            <option value="elem_17">elem 17</option>
                                            <option value="elem_18">elem 18</option>
                                            <option value="elem_19">elem 19</option>
                                            <option value="elem_20">elem 20</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-sm-6">
                                        <h5 class="box-title">Optgroup</h5>
                                        <select multiple id="optgroup" name="optgroup[]">
                                            <optgroup label="Friends">
                                                <option value="1">Yoda</option>
                                                <option value="2" selected disabled>Obiwan</option>
                                            </optgroup>
                                            <optgroup label="Enemies">
                                                <option value="3">Palpatine</option>
                                                <option value="4" disabled>Darth Vader</option>
                                            </optgroup>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-sm-6">
                                        <h5 class="box-title">Public methods</h5>
                                        <select multiple id="public-methods" name="public-methods[]">
                                            <option value="elem_1">elem 1</option>
                                            <option value="elem_2" disabled>elem 2</option>
                                            <option value="elem_3">elem 3</option>
                                            <option value="elem_4">elem 4</option>
                                            <option value="elem_5">elem 5</option>
                                            <option value="elem_6">elem 6</option>
                                            <option value="elem_7">elem 7</option>
                                            <option value="elem_8">elem 8</option>
                                            <option value="elem_9">elem 9</option>
                                            <option value="elem_10">elem 10</option>
                                            <option value="elem_11">elem 11</option>
                                            <option value="elem_12">elem 12</option>
                                            <option value="elem_13">elem 13</option>
                                            <option value="elem_14">elem 14</option>
                                            <option value="elem_15">elem 15</option>
                                            <option value="elem_16">elem 16</option>
                                            <option value="elem_17">elem 17</option>
                                            <option value="elem_18">elem 18</option>
                                            <option value="elem_19">elem 19</option>
                                            <option value="elem_20">elem 20</option>
                                            <option value="elem_21">elem 21</option>
                                            <option value="elem_22">elem 22</option>
                                            <option value="elem_23">elem 23</option>
                                            <option value="elem_24">elem 24</option>
                                            <option value="elem_25">elem 25</option>
                                            <option value="elem_26">elem 26</option>
                                            <option value="elem_27">elem 27</option>
                                            <option value="elem_28">elem 28</option>
                                            <option value="elem_29">elem 29</option>
                                            <option value="elem_30">elem 30</option>
                                            <option value="elem_31">elem 31</option>
                                            <option value="elem_32">elem 32</option>
                                            <option value="elem_33">elem 33</option>
                                            <option value="elem_34">elem 34</option>
                                            <option value="elem_35">elem 35</option>
                                            <option value="elem_36">elem 36</option>
                                            <option value="elem_37">elem 37</option>
                                            <option value="elem_38">elem 38</option>
                                            <option value="elem_39">elem 39</option>
                                            <option value="elem_40">elem 40</option>
                                            <option value="elem_41">elem 41</option>
                                            <option value="elem_42">elem 42</option>
                                            <option value="elem_43">elem 43</option>
                                            <option value="elem_44">elem 44</option>
                                            <option value="elem_45">elem 45</option>
                                            <option value="elem_46">elem 46</option>
                                            <option value="elem_47">elem 47</option>
                                            <option value="elem_48">elem 48</option>
                                            <option value="elem_49">elem 49</option>
                                            <option value="elem_50">elem 50</option>
                                            <option value="elem_51">elem 51</option>
                                            <option value="elem_52">elem 52</option>
                                            <option value="elem_53">elem 53</option>
                                            <option value="elem_54">elem 54</option>
                                            <option value="elem_55">elem 55</option>
                                            <option value="elem_56">elem 56</option>
                                            <option value="elem_57">elem 57</option>
                                            <option value="elem_58">elem 58</option>
                                            <option value="elem_59">elem 59</option>
                                            <option value="elem_60">elem 60</option>
                                            <option value="elem_61">elem 61</option>
                                            <option value="elem_62">elem 62</option>
                                            <option value="elem_63">elem 63</option>
                                            <option value="elem_64">elem 64</option>
                                            <option value="elem_65">elem 65</option>
                                            <option value="elem_66">elem 66</option>
                                            <option value="elem_67">elem 67</option>
                                            <option value="elem_68">elem 68</option>
                                            <option value="elem_69">elem 69</option>
                                            <option value="elem_70">elem 70</option>
                                            <option value="elem_71">elem 71</option>
                                            <option value="elem_72">elem 72</option>
                                            <option value="elem_73">elem 73</option>
                                            <option value="elem_74">elem 74</option>
                                            <option value="elem_75">elem 75</option>
                                            <option value="elem_76">elem 76</option>
                                            <option value="elem_77">elem 77</option>
                                            <option value="elem_78">elem 78</option>
                                            <option value="elem_79">elem 79</option>
                                            <option value="elem_80">elem 80</option>
                                            <option value="elem_81">elem 81</option>
                                            <option value="elem_82">elem 82</option>
                                            <option value="elem_83">elem 83</option>
                                            <option value="elem_84">elem 84</option>
                                            <option value="elem_85">elem 85</option>
                                            <option value="elem_86">elem 86</option>
                                            <option value="elem_87">elem 87</option>
                                            <option value="elem_88">elem 88</option>
                                            <option value="elem_89">elem 89</option>
                                            <option value="elem_90">elem 90</option>
                                            <option value="elem_91">elem 91</option>
                                            <option value="elem_92">elem 92</option>
                                            <option value="elem_93">elem 93</option>
                                            <option value="elem_94">elem 94</option>
                                            <option value="elem_95">elem 95</option>
                                            <option value="elem_96">elem 96</option>
                                            <option value="elem_97">elem 97</option>
                                            <option value="elem_98">elem 98</option>
                                            <option value="elem_99">elem 99</option>
                                            <option value="elem_100">elem 100</option>
                                            <option value="elem_101">elem 101</option>
                                            <option value="elem_102">elem 102</option>
                                            <option value="elem_103">elem 103</option>
                                            <option value="elem_104">elem 104</option>
                                            <option value="elem_105">elem 105</option>
                                            <option value="elem_106">elem 106</option>
                                            <option value="elem_107">elem 107</option>
                                            <option value="elem_108">elem 108</option>
                                            <option value="elem_109">elem 109</option>
                                            <option value="elem_110">elem 110</option>
                                            <option value="elem_111">elem 111</option>
                                            <option value="elem_112">elem 112</option>
                                            <option value="elem_113">elem 113</option>
                                            <option value="elem_114">elem 114</option>
                                            <option value="elem_115">elem 115</option>
                                            <option value="elem_116">elem 116</option>
                                            <option value="elem_117">elem 117</option>
                                            <option value="elem_118">elem 118</option>
                                            <option value="elem_119">elem 119</option>
                                            <option value="elem_120">elem 120</option>
                                            <option value="elem_121">elem 121</option>
                                            <option value="elem_122">elem 122</option>
                                            <option value="elem_123">elem 123</option>
                                            <option value="elem_124">elem 124</option>
                                            <option value="elem_125">elem 125</option>
                                            <option value="elem_126">elem 126</option>
                                            <option value="elem_127">elem 127</option>
                                            <option value="elem_128">elem 128</option>
                                            <option value="elem_129">elem 129</option>
                                            <option value="elem_130">elem 130</option>
                                            <option value="elem_131">elem 131</option>
                                            <option value="elem_132">elem 132</option>
                                            <option value="elem_133">elem 133</option>
                                            <option value="elem_134">elem 134</option>
                                            <option value="elem_135">elem 135</option>
                                            <option value="elem_136">elem 136</option>
                                            <option value="elem_137">elem 137</option>
                                            <option value="elem_138">elem 138</option>
                                            <option value="elem_139">elem 139</option>
                                            <option value="elem_140">elem 140</option>
                                            <option value="elem_141">elem 141</option>
                                            <option value="elem_142">elem 142</option>
                                            <option value="elem_143">elem 143</option>
                                            <option value="elem_144">elem 144</option>
                                            <option value="elem_145">elem 145</option>
                                            <option value="elem_146">elem 146</option>
                                            <option value="elem_147">elem 147</option>
                                            <option value="elem_148">elem 148</option>
                                            <option value="elem_149">elem 149</option>
                                            <option value="elem_150">elem 150</option>
                                            <option value="elem_151">elem 151</option>
                                            <option value="elem_152">elem 152</option>
                                            <option value="elem_153">elem 153</option>
                                            <option value="elem_154">elem 154</option>
                                            <option value="elem_155">elem 155</option>
                                            <option value="elem_156">elem 156</option>
                                            <option value="elem_157">elem 157</option>
                                            <option value="elem_158">elem 158</option>
                                            <option value="elem_159">elem 159</option>
                                            <option value="elem_160">elem 160</option>
                                            <option value="elem_161">elem 161</option>
                                            <option value="elem_162">elem 162</option>
                                            <option value="elem_163">elem 163</option>
                                            <option value="elem_164">elem 164</option>
                                            <option value="elem_165">elem 165</option>
                                            <option value="elem_166">elem 166</option>
                                            <option value="elem_167">elem 167</option>
                                            <option value="elem_168">elem 168</option>
                                            <option value="elem_169">elem 169</option>
                                            <option value="elem_170">elem 170</option>
                                            <option value="elem_171">elem 171</option>
                                            <option value="elem_172">elem 172</option>
                                            <option value="elem_173">elem 173</option>
                                            <option value="elem_174">elem 174</option>
                                            <option value="elem_175">elem 175</option>
                                            <option value="elem_176">elem 176</option>
                                            <option value="elem_177">elem 177</option>
                                            <option value="elem_178">elem 178</option>
                                            <option value="elem_179">elem 179</option>
                                            <option value="elem_180">elem 180</option>
                                            <option value="elem_181">elem 181</option>
                                            <option value="elem_182">elem 182</option>
                                            <option value="elem_183">elem 183</option>
                                            <option value="elem_184">elem 184</option>
                                            <option value="elem_185">elem 185</option>
                                            <option value="elem_186">elem 186</option>
                                            <option value="elem_187">elem 187</option>
                                            <option value="elem_188">elem 188</option>
                                            <option value="elem_189">elem 189</option>
                                            <option value="elem_190">elem 190</option>
                                            <option value="elem_191">elem 191</option>
                                            <option value="elem_192">elem 192</option>
                                            <option value="elem_193">elem 193</option>
                                            <option value="elem_194">elem 194</option>
                                            <option value="elem_195">elem 195</option>
                                            <option value="elem_196">elem 196</option>
                                            <option value="elem_197">elem 197</option>
                                            <option value="elem_198">elem 198</option>
                                            <option value="elem_199">elem 199</option>
                                            <option value="elem_200">elem 200</option>
                                        </select>
                                        <div class="button-box m-t-20"> <a id="select-all" class="btn btn-danger btn-outline" href="#">select all</a> <a id="deselect-all" class="btn btn-info btn-outline" href="#">deselect all</a> <a id="add-option" class="btn btn-success btn-outline" href="#">Add option</a> <a id="refresh" class="btn btn-warning btn-outline" href="#">refresh</a> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.row -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="white-box">
                                <div class="row">
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                        <h3 class="box-title m-b-0">Checkbox Square</h3>
                                        <p class="text-muted font-13 m-b-30"> Bootstrap brand colors </p>
                                        <div class="checkbox">
                                            <input id="checkbox0" type="checkbox">
                                            <label for="checkbox0"> Default </label>
                                        </div>
                                        <div class="checkbox checkbox-custom">
                                            <input id="checkbox11" type="checkbox" checked>
                                            <label for="checkbox11"> Custom </label>
                                        </div>
                                        <div class="checkbox checkbox-primary">
                                            <input id="checkbox2" type="checkbox" checked>
                                            <label for="checkbox2"> Primary </label>
                                        </div>
                                        <div class="checkbox checkbox-success">
                                            <input id="checkbox3" type="checkbox">
                                            <label for="checkbox3"> Success </label>
                                        </div>
                                        <div class="checkbox checkbox-info">
                                            <input id="checkbox4" type="checkbox">
                                            <label for="checkbox4"> Info </label>
                                        </div>
                                        <div class="checkbox checkbox-warning">
                                            <input id="checkbox5" type="checkbox" checked>
                                            <label for="checkbox5"> Warning </label>
                                        </div>
                                        <div class="checkbox checkbox-danger">
                                            <input id="checkbox6" type="checkbox" checked>
                                            <label for="checkbox6"> Danger </label>
                                        </div>
                                        <div class="checkbox checkbox-purple">
                                            <input id="checkbox6a" type="checkbox">
                                            <label for="checkbox6a"> Purple </label>
                                        </div>
                                        <div class="checkbox checkbox-inverse">
                                            <input id="checkbox6c" type="checkbox">
                                            <label for="checkbox6c"> Inverse </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                        <h3 class="box-title m-b-0">Checkbox Circle</h3>
                                        <p class="text-muted font-13 m-b-30"> Add simple <code>checkbox-circle</code> class </p>
                                        <div class="checkbox checkbox-circle">
                                            <input id="checkbox7" type="checkbox">
                                            <label for="checkbox7"> Simply Rounded </label>
                                        </div>
                                        <div class="checkbox checkbox-info checkbox-circle">
                                            <input id="checkbox8" type="checkbox" checked>
                                            <label for="checkbox8"> Info </label>
                                        </div>
                                        <div class="checkbox checkbox-primary checkbox-circle">
                                            <input id="checkbox-9" type="checkbox">
                                            <label for="checkbox-9"> Primary </label>
                                        </div>
                                        <div class="checkbox checkbox-success checkbox-circle">
                                            <input id="checkbox-10" type="checkbox" checked>
                                            <label for="checkbox-10"> Success </label>
                                        </div>
                                        <div class="checkbox checkbox-warning checkbox-circle">
                                            <input id="checkbox-11" type="checkbox">
                                            <label for="checkbox-11"> Warning </label>
                                        </div>
                                        <div class="checkbox checkbox-danger checkbox-circle">
                                            <input id="checkbox-12" type="checkbox" checked>
                                            <label for="checkbox-12"> Danger </label>
                                        </div>
                                        <div class="checkbox checkbox-purple checkbox-circle">
                                            <input id="checkbox-13" type="checkbox" checked>
                                            <label for="checkbox-13"> Purple </label>
                                        </div>
                                        <div class="checkbox checkbox-inverse checkbox-circle">
                                            <input id="checkbox-15" type="checkbox" checked>
                                            <label for="checkbox-15"> Inverse </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-xs-12">
                                        <h3 class="box-title m-b-0">Checkbox Disable</h3>
                                        <p class="text-muted font-13 m-b-30"> Disable state </p>
                                        <div class="checkbox">
                                            <input id="checkbox9" type="checkbox" disabled>
                                            <label for="checkbox9"> Can't check this </label>
                                        </div>
                                        <div class="checkbox checkbox-warning checkbox-circle">
                                            <input id="checkbox110" type="checkbox" disabled checked>
                                            <label for="checkbox110"> And this </label>
                                        </div>
                                        <div class="checkbox checkbox-info">
                                            <input id="checkbox12" type="checkbox" disabled checked>
                                            <label for="checkbox12"> Can't check this </label>
                                        </div>
                                        <div class="checkbox checkbox-purple checkbox-circle">
                                            <input id="checkbox14" type="checkbox" disabled checked>
                                            <label for="checkbox14"> And this </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                        <h3 class="box-title m-b-0">Radio Buttons</h3>
                                        <p class="text-muted font-13 m-b-30"> With bootstrap colors </p>
                                        <div class="radio">
                                            <input type="radio" name="radio" id="radio1" value="option1" checked>
                                            <label for="radio1"> Default </label>
                                        </div>
                                        <div class="radio radio-custom">
                                            <input type="radio" name="radio" id="radio2" value="option2">
                                            <label for="radio2"> Custom </label>
                                        </div>
                                        <div class="radio radio-primary">
                                            <input type="radio" name="radio" id="radio3" value="option3">
                                            <label for="radio3"> Primary </label>
                                        </div>
                                        <div class="radio radio-success">
                                            <input type="radio" name="radio" id="radio4" value="option4">
                                            <label for="radio4"> Success </label>
                                        </div>
                                        <div class="radio radio-info">
                                            <input type="radio" name="radio" id="radio5" value="option5">
                                            <label for="radio5"> Info </label>
                                        </div>
                                        <div class="radio radio-danger">
                                            <input type="radio" name="radio" id="radio6" value="option6">
                                            <label for="radio6"> Danger </label>
                                        </div>
                                        <div class="radio radio-warning">
                                            <input type="radio" name="radio" id="radio7" value="option7">
                                            <label for="radio7"> Warning </label>
                                        </div>
                                        <div class="radio radio-purple">
                                            <input type="radio" name="radio" id="radio8" value="option8">
                                            <label for="radio8"> Purple </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                        <h3 class="box-title m-b-0">Radio Clickable</h3>
                                        <p class="text-muted font-13 m-b-30"> All buttons clickable </p>
                                        <div class="radio">
                                            <input type="radio" name="radio1" id="radio11" value="option1" checked>
                                            <label for="radio11"> Default </label>
                                        </div>
                                        <div class="radio radio-custom">
                                            <input type="radio" name="radio2" id="radio12" value="option2">
                                            <label for="radio12"> Custom </label>
                                        </div>
                                        <div class="radio radio-primary">
                                            <input type="radio" name="radio3" id="radio13" value="option3">
                                            <label for="radio13"> Primary </label>
                                        </div>
                                        <div class="radio radio-success">
                                            <input type="radio" name="radio4" id="radio14" value="option4" checked>
                                            <label for="radio14"> Success </label>
                                        </div>
                                        <div class="radio radio-info">
                                            <input type="radio" name="radio5" id="radio15" value="option5" checked>
                                            <label for="radio15"> Info </label>
                                        </div>
                                        <div class="radio radio-danger">
                                            <input type="radio" name="radio6" id="radio16" value="option6">
                                            <label for="radio16"> Danger </label>
                                        </div>
                                        <div class="radio radio-warning">
                                            <input type="radio" name="radio7" id="radio17" value="option7" checked>
                                            <label for="radio17"> Warning </label>
                                        </div>
                                        <div class="radio radio-purple">
                                            <input type="radio" name="radio8" id="radio18" value="option8">
                                            <label for="radio18"> Purple </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                        <h3 class="box-title m-b-0">Radio Disable</h3>
                                        <p class="text-muted font-13 m-b-30"> Disable state </p>
                                        <div class="radio">
                                            <input type="radio" name="radio21" id="radio21" value="option1" disabled checked>
                                            <label for="radio21"> Default </label>
                                        </div>
                                        <div class="radio radio-custom">
                                            <input type="radio" name="radio22" disabled id="radio22" value="option2">
                                            <label for="radio22"> Custom </label>
                                        </div>
                                        <div class="radio radio-primary">
                                            <input type="radio" name="radio23" disabled id="radio23" value="option3">
                                            <label for="radio23"> Primary </label>
                                        </div>
                                        <div class="radio radio-success">
                                            <input type="radio" name="radio24" disabled id="radio24" value="option4" checked>
                                            <label for="radio24"> Success </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- .row -->
                    <!-- /.row -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                    <div class="right-sidebar">
                        <div class="slimscrollright">
                            <div class="rpanel-title"> Service Panel <span><i class="ti-close right-side-toggle"></i></span> </div>
                            <div class="r-panel-body">
                                <ul id="themecolors" class="m-t-20">
                                    <li><b>With Light sidebar</b></li>
                                    <li><a href="javascript:void(0)" data-theme="default" class="default-theme">1</a></li>
                                    <li><a href="javascript:void(0)" data-theme="green" class="green-theme">2</a></li>
                                    <li><a href="javascript:void(0)" data-theme="gray" class="yellow-theme">3</a></li>
                                    <li><a href="javascript:void(0)" data-theme="blue" class="blue-theme">4</a></li>
                                    <li><a href="javascript:void(0)" data-theme="purple" class="purple-theme">5</a></li>
                                    <li><a href="javascript:void(0)" data-theme="megna" class="megna-theme">6</a></li>
                                    <li><b>With Dark sidebar</b></li>
                                    <br/>
                                    <li><a href="javascript:void(0)" data-theme="default-dark" class="default-dark-theme">7</a></li>
                                    <li><a href="javascript:void(0)" data-theme="green-dark" class="green-dark-theme">8</a></li>
                                    <li><a href="javascript:void(0)" data-theme="gray-dark" class="yellow-dark-theme">9</a></li>
                                    <li><a href="javascript:void(0)" data-theme="blue-dark" class="blue-dark-theme working">10</a></li>
                                    <li><a href="javascript:void(0)" data-theme="purple-dark" class="purple-dark-theme">11</a></li>
                                    <li><a href="javascript:void(0)" data-theme="megna-dark" class="megna-dark-theme">12</a></li>
                                </ul>
                                <ul class="m-t-20 all-demos">
                                    <li><b>Choose other demos</b></li>
                                </ul>
                                <ul class="m-t-20 chatonline">
                                    <li><b>Chat option</b></li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/varun.jpg" alt="user-img" class="img-circle"> <span>Varun Dhavan <small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/genu.jpg" alt="user-img" class="img-circle"> <span>Genelia Deshmukh <small class="text-warning">Away</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/ritesh.jpg" alt="user-img" class="img-circle"> <span>Ritesh Deshmukh <small class="text-danger">Busy</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/arijit.jpg" alt="user-img" class="img-circle"> <span>Arijit Sinh <small class="text-muted">Offline</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/govinda.jpg" alt="user-img" class="img-circle"> <span>Govinda Star <small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/hritik.jpg" alt="user-img" class="img-circle"> <span>John Abraham<small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/john.jpg" alt="user-img" class="img-circle"> <span>Hritik Roshan<small class="text-success">online</small></span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)"><img src="../plugins/images/users/pawandeep.jpg" alt="user-img" class="img-circle"> <span>Pwandeep rajan <small class="text-success">online</small></span></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- /.container-fluid -->
                <footer class="footer text-center"> 2017 &copy; Ample Admin brought to you by themedesigner.in </footer>
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <!-- jQuery -->
        <script src="../plugins/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- Menu Plugin JavaScript -->
        <script src="../plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
        <!--slimscroll JavaScript -->
        <script src="js/jquery.slimscroll.js"></script>
        <!--Wave Effects -->
        <script src="js/waves.js"></script>
        <!-- Custom Theme JavaScript -->
        <script src="js/custom.min.js"></script>
        <script src="../plugins/bower_components/switchery/dist/switchery.min.js"></script>
        <script src="../plugins/bower_components/custom-select/custom-select.min.js" type="text/javascript"></script>
        <script src="../plugins/bower_components/bootstrap-select/bootstrap-select.min.js" type="text/javascript"></script>
        <script src="../plugins/bower_components/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
        <script src="../plugins/bower_components/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../plugins/bower_components/multiselect/js/jquery.multi-select.js"></script>
        <script>
        jQuery(document).ready(function() {
            // Switchery
            var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
            $('.js-switch').each(function() {
                new Switchery($(this)[0], $(this).data());
            });
            // For select 2
            $(".select2").select2();
            $('.selectpicker').selectpicker();
            //Bootstrap-TouchSpin
            $(".vertical-spin").TouchSpin({
                verticalbuttons: true,
                verticalupclass: 'ti-plus',
                verticaldownclass: 'ti-minus'
            });
            var vspinTrue = $(".vertical-spin").TouchSpin({
                verticalbuttons: true
            });
            if (vspinTrue) {
                $('.vertical-spin').prev('.bootstrap-touchspin-prefix').remove();
            }
            $("input[name='tch1']").TouchSpin({
                min: 0,
                max: 100,
                step: 0.1,
                decimals: 2,
                boostat: 5,
                maxboostedstep: 10,
                postfix: '%'
            });
            $("input[name='tch2']").TouchSpin({
                min: -1000000000,
                max: 1000000000,
                stepinterval: 50,
                maxboostedstep: 10000000,
                prefix: '$'
            });
            $("input[name='tch3']").TouchSpin();
            $("input[name='tch3_22']").TouchSpin({
                initval: 40
            });
            $("input[name='tch5']").TouchSpin({
                prefix: "pre",
                postfix: "post"
            });
            // For multiselect
            $('#pre-selected-options').multiSelect();
            $('#optgroup').multiSelect({
                selectableOptgroup: true
            });
            $('#public-methods').multiSelect();
            $('#select-all').click(function() {
                $('#public-methods').multiSelect('select_all');
                return false;
            });
            $('#deselect-all').click(function() {
                $('#public-methods').multiSelect('deselect_all');
                return false;
            });
            $('#refresh').on('click', function() {
                $('#public-methods').multiSelect('refresh');
                return false;
            });
            $('#add-option').on('click', function() {
                $('#public-methods').multiSelect('addOption', {
                    value: 42,
                    text: 'test 42',
                    index: 0
                });
                return false;
            });
        });
        </script>
        <!--Style Switcher -->
        <script src="../plugins/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>