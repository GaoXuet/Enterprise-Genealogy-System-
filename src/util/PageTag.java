package util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import action.PagingBean;

public class PageTag extends SimpleTagSupport {
	private PagingBean pagingBean;
	private HttpServletRequest request;

	/*
	 * <li class="active"><a href="#">1</a></li> <li><a href="#">2</a></li>
	 * <li><a href="#">3</a></li> <li><a href="#">4</a></li> <li><a
	 * href="#">5</a></li> <li><a href="#">&raquo;</a></li>
	 */

	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb = new StringBuffer();
		if (pagingBean != null) {
			System.out.println(
					"PagTag显示路径：" + pagingBean.getPrefixUrl() + "?currentPage=" + (pagingBean.getCountPerPage() - 1));
			// 定义导航链接的部分呢——如果文档中有“前后”按钮，则应该把它放到 <nav> 元素中。
			sb.append("<nav><ul class='pagination'>");

			sb.append("<li><a href='#'");
			sb.append("<span>");
			sb.append(pagingBean.getCurrentPage() + 1);
			sb.append("/");
			sb.append(pagingBean.getPageCount());
			sb.append("</span>");
			sb.append("</a></li>");

			// 处理上一页和首页
			if (pagingBean.getCurrentPage() <= 0) {
				// 当前页为第一页
				// 则首页按钮和上一页 按钮为不可用状态——点击无效
				sb.append("<li class='disabled'><a href='#'>首页</a></li>");
				sb.append("<li class='disabled'><a href='#'>上一页</a></li>");
			} else {
				// 当前页不是第一页，则首页和上一页为可用状态——点击有效
				sb.append("<li><a href='").append(pagingBean.getPrefixUrl())
						.append("' aria-label='Previous'><span aria-hidden='true'>首页</span></a></li>");
				sb.append("<li><a href='").append(pagingBean.getPrefixUrl()).append(pagingBean.isAnd() ? "?" : "?")
						.append("currentPage=").append(pagingBean.getCurrentPage() - 1)
						.append("'><span aria-hidden='true'>上一页</span></a></li>");
			}
			// 处理下一页和尾页
			if (pagingBean.getCurrentPage() >= (pagingBean.getPageCount() - 1)) {
				// 当前页是最后一页，下一页和尾页按钮不可用状态——点击无效
				sb.append("<li class='disabled'><a>下一页</a></li>");
				sb.append("<li class='disabled'><a>尾页</a></li>");
			} else {
				// 当前页不是最后一页
				sb.append("<li><a href='").append(pagingBean.getPrefixUrl()).append(pagingBean.isAnd() ? "?" : "?")
						.append("currentPage=").append(pagingBean.getCurrentPage() + 1)
						.append("'><span aria-hidden='true'>下一页</span></a></li>");

				sb.append("<li><a href='").append(pagingBean.getPrefixUrl()).append(pagingBean.isAnd() ? "?" : "?")
						.append("currentPage=").append(pagingBean.getPageCount() - 1)
						.append("' aria-label='Previous'><span aria-hidden='true'>尾页</span></a></li>");
			}

			sb.append("</ul></nav>");
			getJspContext().getOut().write(sb.toString());

		}
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
