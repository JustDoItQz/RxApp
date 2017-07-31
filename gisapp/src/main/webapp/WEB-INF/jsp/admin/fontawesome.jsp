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
    <!-- Menu CSS -->
    <link href="../plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
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
                    <li> <a href="forms.html" class="waves-effect"><i class="mdi mdi-clipboard-text fa-fw"></i> <span class="hide-menu">Forms<span class="fa arrow"></span></span></a>
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
                    <li> <a href="#" class="waves-effect active"><i class="mdi mdi-emoticon fa-fw"></i> <span class="hide-menu">Icons<span class="fa arrow"></span></span></a>
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
                        <h4 class="page-title">Fontawesome Page</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <button class="right-side-toggle waves-effect waves-light btn-info btn-circle pull-right m-l-20"><i class="ti-settings text-white"></i></button>
                        <a href="javascript: void(0);" target="_blank" class="btn btn-danger pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">Buy Admin Now</a>
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Icons</a></li>
                            <li class="active">Fontawesome Icons</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section>
                                <h3 class="box-title">20 New Icons in 4.5</h3>
                                <div class="icon-list-demo clearfix">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bluetooth"></i>fa fa-bluetooth</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bluetooth-b"></i>fa fa-bluetooth-b</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-codiepie"></i>fa fa-codiepie</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-credit-card-alt"></i>fa fa-credit-card-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-edge"></i>fa fa-edge</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fort-awesome"></i>fa fa-fort-awesome</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hashtag"></i>fa fa-hashtag</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mixcloud"></i>fa fa-mixcloud</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-modx"></i>fa fa-modx</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pause-circle"></i>fa fa-pause-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pause-circle-o"></i>fa fa-pause-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-percent"></i>fa fa-percent</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-product-hunt"></i>fa fa-product-hunt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-reddit-alien"></i>fa fa-reddit-alien</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-scribd"></i>fa fa-scribd</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-shopping-bag"></i>fa fa-shopping-bag</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-shopping-basket"></i>fa fa-shopping-basket</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stop-circle"></i>fa fa-stop-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stop-circle-o"></i>fa fa-stop-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-usb"></i>fa fa-usb</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section>
                                <h3 class="box-title">Web App Icons</h3>
                                <div class="clearfix icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-adjust"></i> fa-adjust</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-anchor"></i> fa-anchor</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-archive"></i> fa-archive</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows"></i> fa-arrows</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows-h"></i> fa-arrows-h</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows-v"></i> fa-arrows-v</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-asterisk"></i> fa-asterisk</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-automobile"></i> fa-automobile <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ban"></i> fa-ban</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bank"></i> fa-bank <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bar-chart-o"></i> fa-bar-chart-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-barcode"></i> fa-barcode</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bars"></i> fa-bars</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-beer"></i> fa-beer</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bell"></i> fa-bell</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bell-o"></i> fa-bell-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bolt"></i> fa-bolt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bomb"></i> fa-bomb</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-book"></i> fa-book</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bookmark"></i> fa-bookmark</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bookmark-o"></i> fa-bookmark-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-briefcase"></i> fa-briefcase</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bug"></i> fa-bug</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-building"></i> fa-building</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-building-o"></i> fa-building-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bullhorn"></i> fa-bullhorn</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bullseye"></i> fa-bullseye</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cab"></i> fa-cab <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-calendar"></i> fa-calendar</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-calendar-o"></i> fa-calendar-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-camera"></i> fa-camera</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-camera-retro"></i> fa-camera-retro</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-car"></i> fa-car</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-down"></i> fa-caret-square-o-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-left"></i> fa-caret-square-o-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-right"></i> fa-caret-square-o-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-up"></i> fa-caret-square-o-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-certificate"></i> fa-certificate</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check"></i> fa-check</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check-circle"></i> fa-check-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check-circle-o"></i> fa-check-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check-square"></i> fa-check-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check-square-o"></i> fa-check-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-child"></i> fa-child</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-circle"></i> fa-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-circle-o"></i> fa-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-circle-o-notch"></i> fa-circle-o-notch</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-circle-thin"></i> fa-circle-thin</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-clock-o"></i> fa-clock-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cloud"></i> fa-cloud</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cloud-download"></i> fa-cloud-download</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cloud-upload"></i> fa-cloud-upload</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-code"></i> fa-code</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-code-fork"></i> fa-code-fork</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-coffee"></i> fa-coffee</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cog"></i> fa-cog</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cogs"></i> fa-cogs</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-comment"></i> fa-comment</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-comment-o"></i> fa-comment-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-comments"></i> fa-comments</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-comments-o"></i> fa-comments-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-compass"></i> fa-compass</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-credit-card"></i> fa-credit-card</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-crop"></i> fa-crop</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-crosshairs"></i> fa-crosshairs</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cube"></i> fa-cube</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cubes"></i> fa-cubes</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cutlery"></i> fa-cutlery</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dashboard"></i> fa-dashboard <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-database"></i> fa-database</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-desktop"></i> fa-desktop</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dot-circle-o"></i> fa-dot-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-download"></i> fa-download</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-edit"></i> fa-edit <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ellipsis-h"></i> fa-ellipsis-h</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ellipsis-v"></i> fa-ellipsis-v</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-envelope"></i> fa-envelope</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-envelope-o"></i> fa-envelope-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-envelope-square"></i> fa-envelope-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-eraser"></i> fa-eraser</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-exchange"></i> fa-exchange</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-exclamation"></i> fa-exclamation</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-exclamation-circle"></i> fa-exclamation-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-exclamation-triangle"></i> fa-exclamation-triangle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-external-link"></i> fa-external-link</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-external-link-square"></i> fa-external-link-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-eye"></i> fa-eye</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-eye-slash"></i> fa-eye-slash</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fax"></i> fa-fax</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-female"></i> fa-female</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fighter-jet"></i> fa-fighter-jet</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-archive-o"></i> fa-file-archive-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-audio-o"></i> fa-file-audio-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-code-o"></i> fa-file-code-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-excel-o"></i> fa-file-excel-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-image-o"></i> fa-file-image-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-movie-o"></i> fa-file-movie-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-pdf-o"></i> fa-file-pdf-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-photo-o"></i> fa-file-photo-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-picture-o"></i> fa-file-picture-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-powerpoint-o"></i> fa-file-powerpoint-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-sound-o"></i> fa-file-sound-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-video-o"></i> fa-file-video-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-word-o"></i> fa-file-word-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-zip-o"></i> fa-file-zip-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-film"></i> fa-film</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-filter"></i> fa-filter</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fire"></i> fa-fire</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fire-extinguisher"></i> fa-fire-extinguisher</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-flag"></i> fa-flag</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-flag-checkered"></i> fa-flag-checkered</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-flag-o"></i> fa-flag-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-flash"></i> fa-flash <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-flask"></i> fa-flask</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-folder"></i> fa-folder</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-folder-o"></i> fa-folder-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-folder-open"></i> fa-folder-open</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-folder-open-o"></i> fa-folder-open-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-frown-o"></i> fa-frown-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gamepad"></i> fa-gamepad</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gavel"></i> fa-gavel</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gear"></i> fa-gear <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gears"></i> fa-gears <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gift"></i> fa-gift</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-glass"></i> fa-glass</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-globe"></i> fa-globe</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-graduation-cap"></i> fa-graduation-cap</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-group"></i> fa-group <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hdd-o"></i> fa-hdd-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-headphones"></i> fa-headphones</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-heart"></i> fa-heart</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-heart-o"></i> fa-heart-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-history"></i> fa-history</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-home"></i> fa-home</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-image"></i> fa-image <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-inbox"></i> fa-inbox</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-info"></i> fa-info</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-info-circle"></i> fa-info-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-institution"></i> fa-institution <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-key"></i> fa-key</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-keyboard-o"></i> fa-keyboard-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-language"></i> fa-language</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-laptop"></i> fa-laptop</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-leaf"></i> fa-leaf</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-legal"></i> fa-legal <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-lemon-o"></i> fa-lemon-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-level-down"></i> fa-level-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-level-up"></i> fa-level-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-life-bouy"></i> fa-life-bouy <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-life-ring"></i> fa-life-ring</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-life-saver"></i> fa-life-saver <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-lightbulb-o"></i> fa-lightbulb-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-location-arrow"></i> fa-location-arrow</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-lock"></i> fa-lock</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-magic"></i> fa-magic</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-magnet"></i> fa-magnet</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mail-forward"></i> fa-mail-forward <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mail-reply"></i> fa-mail-reply <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mail-reply-all"></i> fa-mail-reply-all <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-male"></i> fa-male</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-map-marker"></i> fa-map-marker</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-meh-o"></i> fa-meh-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-microphone"></i> fa-microphone</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-microphone-slash"></i> fa-microphone-slash</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-minus"></i> fa-minus</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-minus-circle"></i> fa-minus-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-minus-square"></i> fa-minus-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-minus-square-o"></i> fa-minus-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mobile"></i> fa-mobile</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mobile-phone"></i> fa-mobile-phone <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-money"></i> fa-money</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-moon-o"></i> fa-moon-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-mortar-board"></i> fa-mortar-board <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-music"></i> fa-music</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-navicon"></i> fa-navicon <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-paper-plane"></i> fa-paper-plane</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-paper-plane-o"></i> fa-paper-plane-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-paw"></i> fa-paw</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pencil"></i> fa-pencil</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pencil-square"></i> fa-pencil-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pencil-square-o"></i> fa-pencil-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-phone"></i> fa-phone</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-phone-square"></i> fa-phone-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-photo"></i> fa-photo <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-picture-o"></i> fa-picture-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plane"></i> fa-plane</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus"></i> fa-plus</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus-circle"></i> fa-plus-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus-square"></i> fa-plus-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus-square-o"></i> fa-plus-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-power-off"></i> fa-power-off</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-print"></i> fa-print</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-puzzle-piece"></i> fa-puzzle-piece</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-qrcode"></i> fa-qrcode</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-question"></i> fa-question</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-question-circle"></i> fa-question-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-quote-left"></i> fa-quote-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-quote-right"></i> fa-quote-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-random"></i> fa-random</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-recycle"></i> fa-recycle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-refresh"></i> fa-refresh</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-reorder"></i> fa-reorder <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-reply"></i> fa-reply</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-reply-all"></i> fa-reply-all</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-retweet"></i> fa-retweet</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-road"></i> fa-road</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rocket"></i> fa-rocket</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rss"></i> fa-rss</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rss-square"></i> fa-rss-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-search"></i> fa-search</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-search-minus"></i> fa-search-minus</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-search-plus"></i> fa-search-plus</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-send"></i> fa-send <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-send-o"></i> fa-send-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share"></i> fa-share</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share-alt"></i> fa-share-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share-alt-square"></i> fa-share-alt-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share-square"></i> fa-share-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share-square-o"></i> fa-share-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-shield"></i> fa-shield</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-shopping-cart"></i> fa-shopping-cart</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sign-in"></i> fa-sign-in</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sign-out"></i> fa-sign-out</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-signal"></i> fa-signal</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sitemap"></i> fa-sitemap</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sliders"></i> fa-sliders</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-smile-o"></i> fa-smile-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort"></i> fa-sort</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-alpha-asc"></i> fa-sort-alpha-asc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-alpha-desc"></i> fa-sort-alpha-desc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-amount-asc"></i> fa-sort-amount-asc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-amount-desc"></i> fa-sort-amount-desc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-asc"></i> fa-sort-asc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-desc"></i> fa-sort-desc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-down"></i> fa-sort-down <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-numeric-asc"></i> fa-sort-numeric-asc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-numeric-desc"></i> fa-sort-numeric-desc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sort-up"></i> fa-sort-up <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-space-shuttle"></i> fa-space-shuttle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spinner"></i> fa-spinner</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spoon"></i> fa-spoon</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-square"></i> fa-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-square-o"></i> fa-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-star"></i> fa-star</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-star-half"></i> fa-star-half</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-star-half-empty"></i> fa-star-half-empty <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-star-half-full"></i> fa-star-half-full <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-star-half-o"></i> fa-star-half-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-star-o"></i> fa-star-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-suitcase"></i> fa-suitcase</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-sun-o"></i> fa-sun-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-support"></i> fa-support <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tablet"></i> fa-tablet</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tachometer"></i> fa-tachometer</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tag"></i> fa-tag</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tags"></i> fa-tags</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tasks"></i> fa-tasks</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-taxi"></i> fa-taxi</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-terminal"></i> fa-terminal</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-thumb-tack"></i> fa-thumb-tack</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-thumbs-down"></i> fa-thumbs-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-thumbs-o-down"></i> fa-thumbs-o-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-thumbs-o-up"></i> fa-thumbs-o-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-thumbs-up"></i> fa-thumbs-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ticket"></i> fa-ticket</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-times"></i> fa-times</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-times-circle"></i> fa-times-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-times-circle-o"></i> fa-times-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tint"></i> fa-tint</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-down"></i> fa-toggle-down <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-left"></i> fa-toggle-left <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-right"></i> fa-toggle-right <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-up"></i> fa-toggle-up <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-trash-o"></i> fa-trash-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tree"></i> fa-tree</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-trophy"></i> fa-trophy</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-truck"></i> fa-truck</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-umbrella"></i> fa-umbrella</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-university"></i> fa-university</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-unlock"></i> fa-unlock</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-unlock-alt"></i> fa-unlock-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-unsorted"></i> fa-unsorted <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-upload"></i> fa-upload</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-user"></i> fa-user</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-users"></i> fa-users</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-video-camera"></i> fa-video-camera</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-volume-down"></i> fa-volume-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-volume-off"></i> fa-volume-off</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-volume-up"></i> fa-volume-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-warning"></i> fa-warning <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-wheelchair"></i> fa-wheelchair</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-wrench"></i> fa-wrench</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="file-type">
                                <h3 class="box-title">File Type Icons</h3>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file"></i> fa-file</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-archive-o"></i> fa-file-archive-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-audio-o"></i> fa-file-audio-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-code-o"></i> fa-file-code-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-excel-o"></i> fa-file-excel-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-image-o"></i> fa-file-image-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-movie-o"></i> fa-file-movie-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-o"></i> fa-file-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-pdf-o"></i> fa-file-pdf-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-photo-o"></i> fa-file-photo-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-picture-o"></i> fa-file-picture-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-powerpoint-o"></i> fa-file-powerpoint-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-sound-o"></i> fa-file-sound-o <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-text"></i> fa-file-text</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-text-o"></i> fa-file-text-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-video-o"></i> fa-file-video-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-word-o"></i> fa-file-word-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-zip-o"></i> fa-file-zip-o <span class="text-muted">(alias)</span> </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="spinner">
                                <h4><b>Spinner Icons</b></h4>
                                <div class="alert alert-success"> These icons work great with the <code>fa-spin</code> class. Check out the <a href="" class="alert-link">spinning icons example</a>. </div>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spin fa-circle-o-notch"></i> fa-circle-o-notch</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spin fa-cog"></i> fa-cog</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spin fa-gear"></i> fa-gear <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spin fa-refresh"></i> fa-refresh</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spin fa-spinner"></i> fa-spinner</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="form-control">
                                <h3 class="box-title">Form Control Icons</h3>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check-square"></i> fa-check-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-check-square-o"></i> fa-check-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-circle"></i> fa-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-circle-o"></i> fa-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dot-circle-o"></i> fa-dot-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-minus-square"></i> fa-minus-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-minus-square-o"></i> fa-minus-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus-square"></i> fa-plus-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus-square-o"></i> fa-plus-square-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-square"></i> fa-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-square-o"></i> fa-square-o</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="currency">
                                <h3 class="box-title">Currency Icons</h3>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bitcoin"></i> fa-bitcoin <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-btc"></i> fa-btc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cny"></i> fa-cny <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dollar"></i> fa-dollar <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-eur"></i> fa-eur</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-euro"></i> fa-euro <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gbp"></i> fa-gbp</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-inr"></i> fa-inr</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-jpy"></i> fa-jpy</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-krw"></i> fa-krw</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-money"></i> fa-money</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rmb"></i> fa-rmb <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rouble"></i> fa-rouble <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rub"></i> fa-rub</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ruble"></i> fa-ruble <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rupee"></i> fa-rupee <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-try"></i> fa-try</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-turkish-lira"></i> fa-turkish-lira <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-usd"></i> fa-usd</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-won"></i> fa-won <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-yen"></i> fa-yen <span class="text-muted">(alias)</span> </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="text-editor">
                                <h3 class="box-title">Text Editor Icons</h3>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-align-center"></i> fa-align-center</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-align-justify"></i> fa-align-justify</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-align-left"></i> fa-align-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-align-right"></i> fa-align-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bold"></i> fa-bold</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chain"></i> fa-chain <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chain-broken"></i> fa-chain-broken</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-clipboard"></i> fa-clipboard</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-columns"></i> fa-columns</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-copy"></i> fa-copy <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-cut"></i> fa-cut <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dedent"></i> fa-dedent <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-eraser"></i> fa-eraser</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file"></i> fa-file</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-o"></i> fa-file-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-text"></i> fa-file-text</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-file-text-o"></i> fa-file-text-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-files-o"></i> fa-files-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-floppy-o"></i> fa-floppy-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-font"></i> fa-font</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-header"></i> fa-header</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-indent"></i> fa-indent</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-italic"></i> fa-italic</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-link"></i> fa-link</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-list"></i> fa-list</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-list-alt"></i> fa-list-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-list-ol"></i> fa-list-ol</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-list-ul"></i> fa-list-ul</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-outdent"></i> fa-outdent</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-paperclip"></i> fa-paperclip</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-paragraph"></i> fa-paragraph</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-paste"></i> fa-paste <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-repeat"></i> fa-repeat</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rotate-left"></i> fa-rotate-left <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rotate-right"></i> fa-rotate-right <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-save"></i> fa-save <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-scissors"></i> fa-scissors</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-strikethrough"></i> fa-strikethrough</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-subscript"></i> fa-subscript</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-superscript"></i> fa-superscript</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-table"></i> fa-table</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-text-height"></i> fa-text-height</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-text-width"></i> fa-text-width</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-th"></i> fa-th</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-th-large"></i> fa-th-large</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-th-list"></i> fa-th-list</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-underline"></i> fa-underline</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-undo"></i> fa-undo</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-unlink"></i> fa-unlink <span class="text-muted">(alias)</span> </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="directional">
                                <h3 class="box-title">Directional Icons</h3>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-double-down"></i> fa-angle-double-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-double-left"></i> fa-angle-double-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-double-right"></i> fa-angle-double-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-double-up"></i> fa-angle-double-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-down"></i> fa-angle-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-left"></i> fa-angle-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-right"></i> fa-angle-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-angle-up"></i> fa-angle-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-down"></i> fa-arrow-circle-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-left"></i> fa-arrow-circle-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-o-down"></i> fa-arrow-circle-o-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-o-left"></i> fa-arrow-circle-o-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-o-right"></i> fa-arrow-circle-o-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-o-up"></i> fa-arrow-circle-o-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-right"></i> fa-arrow-circle-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-circle-up"></i> fa-arrow-circle-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-down"></i> fa-arrow-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-left"></i> fa-arrow-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-right"></i> fa-arrow-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrow-up"></i> fa-arrow-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows"></i> fa-arrows</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows-alt"></i> fa-arrows-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows-h"></i> fa-arrows-h</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows-v"></i> fa-arrows-v</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-down"></i> fa-caret-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-left"></i> fa-caret-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-right"></i> fa-caret-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-up"></i> fa-caret-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-left"></i> fa-caret-square-o-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-right"></i> fa-caret-square-o-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-up"></i> fa-caret-square-o-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-caret-square-o-down"></i> fa-caret-square-o-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-circle-down"></i> fa-chevron-circle-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-circle-left"></i> fa-chevron-circle-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-circle-right"></i> fa-chevron-circle-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-circle-up"></i> fa-chevron-circle-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-down"></i> fa-chevron-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-left"></i> fa-chevron-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-right"></i> fa-chevron-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-chevron-up"></i> fa-chevron-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hand-o-down"></i> fa-hand-o-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hand-o-left"></i> fa-hand-o-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hand-o-right"></i> fa-hand-o-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hand-o-up"></i> fa-hand-o-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-long-arrow-down"></i> fa-long-arrow-down</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-long-arrow-left"></i> fa-long-arrow-left</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-long-arrow-right"></i> fa-long-arrow-right</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-long-arrow-up"></i> fa-long-arrow-up</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-down"></i> fa-toggle-down <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-left"></i> fa-toggle-left <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-right"></i> fa-toggle-right <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-toggle-up"></i> fa-toggle-up <span class="text-muted">(alias)</span> </div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="video-player">
                                <h4><b>Video Player Icons</b></h4>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-arrows-alt"></i> fa-arrows-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-backward"></i> fa-backward</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-compress"></i> fa-compress</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-eject"></i> fa-eject</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-expand"></i> fa-expand</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fast-backward"></i> fa-fast-backward</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-fast-forward"></i> fa-fast-forward</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-forward"></i> fa-forward</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pause"></i> fa-pause</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-play"></i> fa-play</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-play-circle"></i> fa-play-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-play-circle-o"></i> fa-play-circle-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-step-backward"></i> fa-step-backward</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-step-forward"></i> fa-step-forward</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stop"></i> fa-stop</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-youtube-play"></i> fa-youtube-play</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="brand">
                                <h3 class="box-title">Brand Icons</h3>
                                <div class="alert alert-success">
                                    <ul class="margin-bottom-none padding-left-lg">
                                        <li>All brand icons are trademarks of their respective owners.</li>
                                        <li>The use of these trademarks does not indicate endorsement of the trademark holder by Font Awesome, nor vice versa.</li>
                                    </ul>
                                </div>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-adn"></i> fa-adn</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-android"></i> fa-android</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-apple"></i> fa-apple</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-behance"></i> fa-behance</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-behance-square"></i> fa-behance-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bitbucket"></i> fa-bitbucket</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bitbucket-square"></i> fa-bitbucket-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-bitcoin"></i> fa-bitcoin <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-btc"></i> fa-btc</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-codepen"></i> fa-codepen</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-css3"></i> fa-css3</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-delicious"></i> fa-delicious</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-deviantart"></i> fa-deviantart</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-digg"></i> fa-digg</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dribbble"></i> fa-dribbble</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-dropbox"></i> fa-dropbox</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-drupal"></i> fa-drupal</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-empire"></i> fa-empire</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-facebook"></i> fa-facebook</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-facebook-square"></i> fa-facebook-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-flickr"></i> fa-flickr</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-foursquare"></i> fa-foursquare</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ge"></i> fa-ge <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-git"></i> fa-git</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-git-square"></i> fa-git-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-github"></i> fa-github</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-github-alt"></i> fa-github-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-github-square"></i> fa-github-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-gittip"></i> fa-gittip</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-google"></i> fa-google</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-google-plus"></i> fa-google-plus</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-google-plus-square"></i> fa-google-plus-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hacker-news"></i> fa-hacker-news</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-html5"></i> fa-html5</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-instagram"></i> fa-instagram</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-joomla"></i> fa-joomla</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-jsfiddle"></i> fa-jsfiddle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-linkedin"></i> fa-linkedin</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-linkedin-square"></i> fa-linkedin-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-linux"></i> fa-linux</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-maxcdn"></i> fa-maxcdn</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-openid"></i> fa-openid</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pagelines"></i> fa-pagelines</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pied-piper"></i> fa-pied-piper</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pied-piper-alt"></i> fa-pied-piper-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pinterest"></i> fa-pinterest</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-pinterest-square"></i> fa-pinterest-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-qq"></i> fa-qq</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ra"></i> fa-ra <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-rebel"></i> fa-rebel</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-reddit"></i> fa-reddit</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-reddit-square"></i> fa-reddit-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-renren"></i> fa-renren</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share-alt"></i> fa-share-alt</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-share-alt-square"></i> fa-share-alt-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-skype"></i> fa-skype</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-slack"></i> fa-slack</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-soundcloud"></i> fa-soundcloud</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-spotify"></i> fa-spotify</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stack-exchange"></i> fa-stack-exchange</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stack-overflow"></i> fa-stack-overflow</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-steam"></i> fa-steam</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-steam-square"></i> fa-steam-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stumbleupon"></i> fa-stumbleupon</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stumbleupon-circle"></i> fa-stumbleupon-circle</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tencent-weibo"></i> fa-tencent-weibo</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-trello"></i> fa-trello</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tumblr"></i> fa-tumblr</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-tumblr-square"></i> fa-tumblr-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-twitter"></i> fa-twitter</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-twitter-square"></i> fa-twitter-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-vimeo-square"></i> fa-vimeo-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-vine"></i> fa-vine</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-vk"></i> fa-vk</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-wechat"></i> fa-wechat <span class="text-muted">(alias)</span> </div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-weibo"></i> fa-weibo</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-weixin"></i> fa-weixin</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-windows"></i> fa-windows</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-wordpress"></i> fa-wordpress</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-xing"></i> fa-xing</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-xing-square"></i> fa-xing-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-yahoo"></i> fa-yahoo</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-youtube"></i> fa-youtube</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-youtube-play"></i> fa-youtube-play</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-youtube-square"></i> fa-youtube-square</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <section id="medical">
                                <h3 class="box-title">Medical Icons</h3>
                                <div class="row icon-list-demo">
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-ambulance"></i> fa-ambulance</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-h-square"></i> fa-h-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-hospital-o"></i> fa-hospital-o</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-medkit"></i> fa-medkit</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-plus-square"></i> fa-plus-square</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-stethoscope"></i> fa-stethoscope</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-user-md"></i> fa-user-md</div>
                                    <div class="col-sm-6 col-md-4 col-lg-3"><i class="fa fa-wheelchair"></i> fa-wheelchair</div>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
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
    <!--Style Switcher -->
    <script src="../plugins/bower_components/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
