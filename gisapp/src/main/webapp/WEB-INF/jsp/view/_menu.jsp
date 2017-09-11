<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="../head.jsp"%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>articlelist.do" title="资讯管理">资讯管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe613;</i> 图片管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>picturelist.do" title="图片管理">图片管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe620;</i> 产品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>productbrand.do" title="品牌管理">品牌管理</a></li>
					<li><a href="<%=pagepath%>productcategory.do" title="分类管理">分类管理</a></li>
					<li><a href="<%=pagepath%>productlist.do" title="产品管理">产品管理</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="http://h-ui.duoshuo.com/admin/" title="评论列表">评论列表</a></li>
					<li><a href="<%=pagepath%>feedbacklist.do" title="意见反馈">意见反馈</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>memberlist.do" title="会员列表">会员列表</a></li>
					<li><a href="<%=pagepath%>memberdel.do" title="删除的会员">删除的会员</a></li>
					<li><a href="<%=pagepath%>memberlevel.do" title="等级管理">等级管理</a></li>
					<li><a href="<%=pagepath%>memberscoreoperation.do" title="积分管理">积分管理</a></li>
					<li><a href="<%=pagepath%>memberrecordbrowse.do" title="浏览记录">浏览记录</a></li>
					<li><a href="<%=pagepath%>memberrecorddownload.do" title="下载记录">下载记录</a></li>
					<li><a href="<%=pagepath%>memberrecordshare.do" title="分享记录">分享记录</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>adminrole.do" title="角色管理">角色管理</a></li>
					<li><a href="<%=pagepath%>adminpermission.do" title="权限管理">权限管理</a></li>
					<li><a href="<%=pagepath%>adminlist.do" title="管理员列表">管理员列表</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-tongji">
			<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>charts1.do" title="折线图">折线图</a></li>
					<li><a href="<%=pagepath%>charts2.do" title="时间轴折线图">时间轴折线图</a></li>
					<li><a href="<%=pagepath%>charts3.do" title="区域图">区域图</a></li>
					<li><a href="<%=pagepath%>charts4.do" title="柱状图">柱状图</a></li>
					<li><a href="<%=pagepath%>charts5.do" title="饼状图">饼状图</a></li>
					<li><a href="<%=pagepath%>charts6.do" title="3D柱状图">3D柱状图</a></li>
					<li><a href="<%=pagepath%>charts7.do" title="3D饼状图">3D饼状图</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu-system">
			<dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a href="<%=pagepath%>systembase.do" title="系统设置">系统设置</a></li>
					<li><a href="<%=pagepath%>systemcategory.do" title="栏目管理">栏目管理</a></li>
					<li><a href="<%=pagepath%>systemdata.do" title="数据字典">数据字典</a></li>
					<li><a href="<%=pagepath%>systemshielding.do" title="屏蔽词">屏蔽词</a></li>
					<li><a href="<%=pagepath%>systemlog.do" title="系统日志">系统日志</a></li>
				</ul>
			</dd>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>