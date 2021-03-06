/**
 * 
 */
package com.phn.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.phn.entity.User;


/**
 * @author 潘海南
 * @email phnlove@163.com
 */
public class UserInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext actx = invocation.getInvocationContext();
		Map session = actx.getSession();
		User u = (User) session.get("sessionUser");
		if (u == null) {
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
