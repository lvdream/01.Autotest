<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
           prefix="tilesx" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="page-content-fixed-header">
    <!-- BEGIN BREADCRUMBS -->
    <ul class="page-breadcrumb">
        <li>
            <a href="#">Skylot</a>
        </li>
        <li>Admin-Server-Console</li>
    </ul>
    <!-- END BREADCRUMBS -->
    <div class="content-header-menu">
        <!-- BEGIN DROPDOWN AJAX MENU -->
        <div class="dropdown-ajax-menu btn-group">
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                    data-close-others="true">
                <i class="fa fa-circle"></i>
                <i class="fa fa-circle"></i>
                <i class="fa fa-circle"></i>
            </button>
            <ul class="dropdown-menu-v2">
                <li>
                    <a href="start.html">Application</a>
                </li>
                <li>
                    <a href="start.html">Reports</a>
                </li>
                <li>
                    <a href="start.html">Templates</a>
                </li>
                <li>
                    <a href="start.html">Settings</a>
                </li>
            </ul>
        </div>
        <!-- END DROPDOWN AJAX MENU -->
        <!-- BEGIN MENU TOGGLER -->
        <button type="button" class="menu-toggler responsive-toggler" data-toggle="collapse"
                data-target=".navbar-collapse">
                            <span class="toggle-icon">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </span>
        </button>
        <!-- END MENU TOGGLER -->
    </div>
</div>