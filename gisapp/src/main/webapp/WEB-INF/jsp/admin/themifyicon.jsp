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
                        <h4 class="page-title">Themifyicon Page</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <button class="right-side-toggle waves-effect waves-light btn-info btn-circle pull-right m-l-20"><i class="ti-settings text-white"></i></button>
                        <a href="javascript: void(0);" target="_blank" class="btn btn-danger pull-right m-l-20 hidden-xs hidden-sm waves-effect waves-light">Buy Admin Now</a>
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Icons</a></li>
                            <li class="active">Themifyicon Icons</li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box clearfix">
                            <h3 class="box-title">Arrows & Direction Icons</h3>
                            <div class="icon-list-demo">
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-up"></i> ti-arrow-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-right"></i> ti-arrow-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-left"></i> ti-arrow-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-down"></i> ti-arrow-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrows-vertical"></i> ti-arrows-vertical </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrows-horizontal"></i> ti-arrows-horizontal </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-up"></i> ti-angle-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-right"></i> ti-angle-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-left"></i> ti-angle-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-down"></i> ti-angle-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-double-up"></i> ti-angle-double-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-double-right"></i> ti-angle-double-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-double-left"></i> ti-angle-double-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-angle-double-down"></i> ti-angle-double-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-move"></i> ti-move </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-fullscreen"></i> ti-fullscreen </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-top-right"></i> ti-arrow-top-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-top-left"></i> ti-arrow-top-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-circle-up"></i> ti-arrow-circle-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-circle-right"></i> ti-arrow-circle-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-circle-left"></i> ti-arrow-circle-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrow-circle-down"></i> ti-arrow-circle-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-arrows-corner"></i> ti-arrows-corner </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-split-v"></i> ti-split-v </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-split-v-alt"></i> ti-split-v-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-split-h"></i> ti-split-h </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-point-up"></i> ti-hand-point-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-point-right"></i> ti-hand-point-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-point-left"></i> ti-hand-point-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-point-down"></i> ti-hand-point-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-back-right"></i> ti-back-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-back-left"></i> ti-back-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-exchange-vertical"></i> ti-exchange-vertical </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box clearfix">
                            <h3 class="box-title">Web App Icons</h3>
                            <div class="icon-list-demo">
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-wand"></i> ti-wand </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-save"></i> ti-save </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-save-alt"></i> ti-save-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-direction"></i> ti-direction </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-direction-alt"></i> ti-direction-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-user"></i> ti-user </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-link"></i> ti-link </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-unlink"></i> ti-unlink </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-trash"></i> ti-trash </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-target"></i> ti-target </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-tag"></i> ti-tag </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-desktop"></i> ti-desktop </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-tablet"></i> ti-tablet </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-mobile"></i> ti-mobile </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-email"></i> ti-email </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-star"></i> ti-star </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-spray"></i> ti-spray </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-signal"></i> ti-signal </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shopping-cart"></i> ti-shopping-cart </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shopping-cart-full"></i> ti-shopping-cart-full </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-settings"></i> ti-settings </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-search"></i> ti-search </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-zoom-in"></i> ti-zoom-in </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-zoom-out"></i> ti-zoom-out </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-cut"></i> ti-cut </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-ruler"></i> ti-ruler </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-ruler-alt-2"></i> ti-ruler-alt-2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-ruler-pencil"></i> ti-ruler-pencil </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-ruler-alt"></i> ti-ruler-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bookmark"></i> ti-bookmark </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bookmark-alt"></i> ti-bookmark-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-reload"></i> ti-reload </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-plus"></i> ti-plus </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-minus"></i> ti-minus </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-close"></i> ti-close </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pin"></i> ti-pin </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pencil"></i> ti-pencil </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pencil-alt"></i> ti-pencil-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-paint-roller"></i> ti-paint-roller </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-paint-bucket"></i> ti-paint-bucket </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-na"></i> ti-na </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-medall"></i> ti-medall </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-medall-alt"></i> ti-medall-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-marker"></i> ti-marker </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-marker-alt"></i> ti-marker-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-lock"></i> ti-lock </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-unlock"></i> ti-unlock </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-location-arrow"></i> ti-location-arrow </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout"></i> ti-layout </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layers"></i> ti-layers </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layers-alt"></i> ti-layers-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-key"></i> ti-key </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-image"></i> ti-image </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-heart"></i> ti-heart </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-heart-broken"></i> ti-heart-broken </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-stop"></i> ti-hand-stop </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-open"></i> ti-hand-open </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hand-drag"></i> ti-hand-drag </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-flag"></i> ti-flag </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-flag-alt"></i> ti-flag-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-flag-alt-2"></i> ti-flag-alt-2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-eye"></i> ti-eye </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-import"></i> ti-import </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-export"></i> ti-export </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-cup"></i> ti-cup </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-crown"></i> ti-crown </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-comments"></i> ti-comments </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-comment"></i> ti-comment </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-comment-alt"></i> ti-comment-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-thought"></i> ti-thought </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-clip"></i> ti-clip </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-check"></i> ti-check </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-check-box"></i> ti-check-box </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-camera"></i> ti-camera </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-announcement"></i> ti-announcement </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-brush"></i> ti-brush </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-brush-alt"></i> ti-brush-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-palette"></i> ti-palette </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-briefcase"></i> ti-briefcase </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bolt"></i> ti-bolt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bolt-alt"></i> ti-bolt-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-blackboard"></i> ti-blackboard </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bag"></i> ti-bag </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-world"></i> ti-world </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-wheelchair"></i> ti-wheelchair </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-car"></i> ti-car </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-truck"></i> ti-truck </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-timer"></i> ti-timer </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-ticket"></i> ti-ticket </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-thumb-up"></i> ti-thumb-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-thumb-down"></i> ti-thumb-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-stats-up"></i> ti-stats-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-stats-down"></i> ti-stats-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shine"></i> ti-shine </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shift-right"></i> ti-shift-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shift-left"></i> ti-shift-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shift-right-alt"></i> ti-shift-right-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shift-left-alt"></i> ti-shift-left-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shield"></i> ti-shield </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-notepad"></i> ti-notepad </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-server"></i> ti-server </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pulse"></i> ti-pulse </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-printer"></i> ti-printer </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-power-off"></i> ti-power-off </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-plug"></i> ti-plug </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pie-chart"></i> ti-pie-chart </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-panel"></i> ti-panel </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-package"></i> ti-package </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-music"></i> ti-music </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-music-alt"></i> ti-music-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-mouse"></i> ti-mouse </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-mouse-alt"></i> ti-mouse-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-money"></i> ti-money </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-microphone"></i> ti-microphone </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-menu"></i> ti-menu </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-menu-alt"></i> ti-menu-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-map"></i> ti-map </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-map-alt"></i> ti-map-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-location-pin"></i> ti-location-pin </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-light-bulb"></i> ti-light-bulb </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-info"></i> ti-info </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-infinite"></i> ti-infinite </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-id-badge"></i> ti-id-badge </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-hummer"></i> ti-hummer </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-home"></i> ti-home </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-help"></i> ti-help </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-headphone"></i> ti-headphone </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-harddrives"></i> ti-harddrives </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-harddrive"></i> ti-harddrive </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-gift"></i> ti-gift </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-game"></i> ti-game </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-filter"></i> ti-filter </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-files"></i> ti-files </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-file"></i> ti-file </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-zip"></i> ti-zip </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-folder"></i> ti-folder </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-envelope"></i> ti-envelope </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-dashboard"></i> ti-dashboard </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-cloud"></i> ti-cloud </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-cloud-up"></i> ti-cloud-up </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-cloud-down"></i> ti-cloud-down </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-clipboard"></i> ti-clipboard </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-calendar"></i> ti-calendar </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-book"></i> ti-book </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bell"></i> ti-bell </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-basketball"></i> ti-basketball </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bar-chart"></i> ti-bar-chart </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-bar-chart-alt"></i> ti-bar-chart-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-archive"></i> ti-archive </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-anchor"></i> ti-anchor </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-alert"></i> ti-alert </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-alarm-clock"></i> ti-alarm-clock </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-agenda"></i> ti-agenda </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-write"></i> ti-write </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-wallet"></i> ti-wallet </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-video-clapper"></i> ti-video-clapper </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-video-camera"></i> ti-video-camera </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-vector"></i> ti-vector </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-support"></i> ti-support </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-stamp"></i> ti-stamp </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-slice"></i> ti-slice </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-shortcode"></i> ti-shortcode </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-receipt"></i> ti-receipt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pin2"></i> ti-pin2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pin-alt"></i> ti-pin-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pencil-alt2"></i> ti-pencil-alt2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-eraser"></i> ti-eraser </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-more"></i> ti-more </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-more-alt"></i> ti-more-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-microphone-alt"></i> ti-microphone-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-magnet"></i> ti-magnet </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-line-double"></i> ti-line-double </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-line-dotted"></i> ti-line-dotted </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-line-dashed"></i> ti-line-dashed </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-ink-pen"></i> ti-ink-pen </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-info-alt"></i> ti-info-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-help-alt"></i> ti-help-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-headphone-alt"></i> ti-headphone-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-gallery"></i> ti-gallery </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-face-smile"></i> ti-face-smile </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-face-sad"></i> ti-face-sad </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-credit-card"></i> ti-credit-card </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-comments-smiley"></i> ti-comments-smiley </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-time"></i> ti-time </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-share"></i> ti-share </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-share-alt"></i> ti-share-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-rocket"></i> ti-rocket </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-new-window"></i> ti-new-window </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-rss"></i> ti-rss </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-rss-alt"></i> ti-rss-alt </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box clearfix">
                            <h4>Control Icons</h4>
                            <div class="icon-list-demo">
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-stop"></i> ti-control-stop </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-shuffle"></i> ti-control-shuffle </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-play"></i> ti-control-play </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-pause"></i> ti-control-pause </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-forward"></i> ti-control-forward </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-backward"></i> ti-control-backward </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-volume"></i> ti-volume </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-skip-forward"></i> ti-control-skip-forward </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-skip-backward"></i> ti-control-skip-backward </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-record"></i> ti-control-record </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-control-eject"></i> ti-control-eject </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box clearfix">
                            <h3 class="box-title">Text Editor Icons</h3>
                            <div class="icon-list-demo">
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-paragraph"></i> ti-paragraph </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-uppercase"></i> ti-uppercase </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-underline"></i> ti-underline </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-text"></i> ti-text </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-Italic"></i> ti-Italic </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-smallcap"></i> ti-smallcap </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-list"></i> ti-list </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-list-ol"></i> ti-list-ol </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-align-right"></i> ti-align-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-align-left"></i> ti-align-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-align-justify"></i> ti-align-justify </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-align-center"></i> ti-align-center </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-quote-right"></i> ti-quote-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-quote-left"></i> ti-quote-left </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box clearfix">
                            <h3 class="box-title">Layout Icons</h3>
                            <div class="icon-list-demo">
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-width-full"></i> ti-layout-width-full </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-width-default"></i> ti-layout-width-default </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-width-default-alt"></i> ti-layout-width-default-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-tab"></i> ti-layout-tab </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-tab-window"></i> ti-layout-tab-window </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-tab-v"></i> ti-layout-tab-v </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-tab-min"></i> ti-layout-tab-min </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-slider"></i> ti-layout-slider </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-slider-alt"></i> ti-layout-slider-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-sidebar-right"></i> ti-layout-sidebar-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-sidebar-none"></i> ti-layout-sidebar-none </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-sidebar-left"></i> ti-layout-sidebar-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-placeholder"></i> ti-layout-placeholder </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-menu"></i> ti-layout-menu </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-menu-v"></i> ti-layout-menu-v </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-menu-separated"></i> ti-layout-menu-separated </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-menu-full"></i> ti-layout-menu-full </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-right"></i> ti-layout-media-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-right-alt"></i> ti-layout-media-right-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-overlay"></i> ti-layout-media-overlay </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-overlay-alt"></i> ti-layout-media-overlay-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-overlay-alt-2"></i> ti-layout-media-overlay-alt-2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-left"></i> ti-layout-media-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-left-alt"></i> ti-layout-media-left-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-center"></i> ti-layout-media-center </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-media-center-alt"></i> ti-layout-media-center-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-list-thumb"></i> ti-layout-list-thumb </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-list-thumb-alt"></i> ti-layout-list-thumb-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-list-post"></i> ti-layout-list-post </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-list-large-image"></i> ti-layout-list-large-image </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-line-solid"></i> ti-layout-line-solid </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid4"></i> ti-layout-grid4 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid3"></i> ti-layout-grid3 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid2"></i> ti-layout-grid2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid2-thumb"></i> ti-layout-grid2-thumb </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-cta-right"></i> ti-layout-cta-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-cta-left"></i> ti-layout-cta-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-cta-center"></i> ti-layout-cta-center </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-cta-btn-right"></i> ti-layout-cta-btn-right </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-cta-btn-left"></i> ti-layout-cta-btn-left </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-column4"></i> ti-layout-column4 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-column3"></i> ti-layout-column3 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-column2"></i> ti-layout-column2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-accordion-separated"></i> ti-layout-accordion-separated </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-accordion-merged"></i> ti-layout-accordion-merged </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-accordion-list"></i> ti-layout-accordion-list </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-widgetized"></i> ti-widgetized </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-widget"></i> ti-widget </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-widget-alt"></i> ti-widget-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-view-list"></i> ti-view-list </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-view-list-alt"></i> ti-view-list-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-view-grid"></i> ti-view-grid </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-upload"></i> ti-upload </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-download"></i> ti-download </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-loop"></i> ti-loop </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-sidebar-2"></i> ti-layout-sidebar-2 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid4-alt"></i> ti-layout-grid4-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid3-alt"></i> ti-layout-grid3-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-grid2-alt"></i> ti-layout-grid2-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-column4-alt"></i> ti-layout-column4-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-column3-alt"></i> ti-layout-column3-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-layout-column2-alt"></i> ti-layout-column2-alt </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box clearfix">
                            <h3 class="box-title">Brand Icons</h3>
                            <div class="icon-list-demo">
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-flickr"></i> ti-flickr </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-flickr-alt"></i> ti-flickr-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-instagram"></i> ti-instagram </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-google"></i> ti-google </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-github"></i> ti-github </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-facebook"></i> ti-facebook </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-dropbox"></i> ti-dropbox </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-dropbox-alt"></i> ti-dropbox-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-dribbble"></i> ti-dribbble </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-apple"></i> ti-apple </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-android"></i> ti-android </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-yahoo"></i> ti-yahoo </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-trello"></i> ti-trello </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-stack-overflow"></i> ti-stack-overflow </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-soundcloud"></i> ti-soundcloud </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-sharethis"></i> ti-sharethis </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-sharethis-alt"></i> ti-sharethis-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-reddit"></i> ti-reddit </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-microsoft"></i> ti-microsoft </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-microsoft-alt"></i> ti-microsoft-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-linux"></i> ti-linux </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-jsfiddle"></i> ti-jsfiddle </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-joomla"></i> ti-joomla </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-html5"></i> ti-html5 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-css3"></i> ti-css3 </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-drupal"></i> ti-drupal </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-wordpress"></i> ti-wordpress </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-tumblr"></i> ti-tumblr </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-tumblr-alt"></i> ti-tumblr-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-skype"></i> ti-skype </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-youtube"></i> ti-youtube </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-vimeo"></i> ti-vimeo </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-vimeo-alt"></i> ti-vimeo-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-twitter"></i> ti-twitter </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-twitter-alt"></i> ti-twitter-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-linkedin"></i> ti-linkedin </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pinterest"></i> ti-pinterest </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-pinterest-alt"></i> ti-pinterest-alt </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-themify-logo"></i> ti-themify-logo </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-themify-favicon"></i> ti-themify-favicon </div>
                                <div class="col-sm-6 col-md-4 col-lg-3"> <i class="ti-themify-favicon-alt"></i> ti-themify-favicon-alt </div>
                            </div>
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
