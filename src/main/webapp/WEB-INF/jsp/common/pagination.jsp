<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="tag.jsp"%>

					<div class="pull-right">
						<nav aria-label="Page navigation">
							<ul class="pagination">
							<c:if test="${page.currentPage != 1}">
								<li><a href="javascript:changeCurrentPage('1')"
									aria-label="Previous"> <span aria-hidden="true">首页</span>
								</a></li>
								<li><a href="javascript:changeCurrentPage('${page.currentPage-1}')"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>
							
							<c:if test="${page.currentPage > 2}">	
								<li><a href="javascript:changeCurrentPage('${page.currentPage-2}')"
									aria-label="Next"> ${page.currentPage-2}
								</a></li>
							</c:if>	

							<c:if test="${page.currentPage > 1}">	
								<li><a href="javascript:changeCurrentPage('${page.currentPage-1}')"
									aria-label="Next"> ${page.currentPage-1}
								</a></li>
							</c:if>	

								<li class="active"><a aria-label="Next"> ${page.currentPage}
								</a></li>

							<c:if test="${page.currentPage < page.totalPage}">	
								<li><a href="javascript:changeCurrentPage('${page.currentPage+1}')"
									aria-label="Next"> ${page.currentPage+1}
								</a></li>
							</c:if>	
								
							<c:if test="${page.currentPage < page.totalPage-1}">	
								<li><a href="javascript:changeCurrentPage('${page.currentPage+2}')"
									aria-label="Next"> ${page.currentPage+2}
								</a></li>
							</c:if>	
							<c:if test="${page.currentPage != page.totalPage}">
								<li><a href="javascript:changeCurrentPage('${page.currentPage+1}')"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
								<li><a href="javascript:changeCurrentPage('${page.totalPage}')"
									aria-label="Next"> <span aria-hidden="true">末页</span>
								</a></li>

							</c:if> 
								<li><a>共${page.totalNumber}条记录</a></li>
							</ul>
						</nav>
					</div>