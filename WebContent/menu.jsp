<!--  Menu Bootstrap -->
<!--  <script src="js/jquery-3.2.1.min.js"></script>  -->

<script src="https://code.jquery.com/jquery-3.2.0.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/dataTables.bootstrap.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">ISTQB TBOK</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Base data<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/TBOK/listBO">List Business Outcome</a></li>
            <li><a href="/TBOK/listBO?edit=0">Add Business Outcome</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/TBOK/listLO">List Learning Objectives</a></li>
            <li><a href="/TBOK/listLO?edit=0">Add Learning Objectives</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/TBOK/listContent">List Content</a></li>
            <li><a href="/TBOK/listContent?edit=0">Add Content</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/TBOK/listGlossary">List Terms</a></li>
            <li><a href="/TBOK/listGlossary?edit=0">Add Term</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/TBOK/listKA">List Knowledge Area</a></li>
            <li><a href="/TBOK/listKA?edit=0">Add Knowledge Area</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/TBOK/listRelease">List Release</a></li>
            <li><a href="/TBOK/listRelease?edit=0">Add Release</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/TBOK/listRules">List Rules</a></li>
            <li><a href="/TBOK/listRules?edit=0">Add Rules</a></li>
            <li role="separator" class="divider"></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Map data<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Map learning objectives</a></li>
            <li><a href="#">Map content</a></li>
            <li><a href="#">Create Release</a></li>
            <li role="separator" class="divider"></li>
          </ul>
        </li>
        
        
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>