package com.demoweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.constant.SystemConstant;
import com.demoweb.model.NewModel;
import com.demoweb.paging.PageRequest;
import com.demoweb.paging.Pageble;
import com.demoweb.service.ICategoryServie;
import com.demoweb.service.INewService;
import com.demoweb.utils.FormUtil;
import com.demoweb.utils.MessageUtil;
@WebServlet(value = "/admin-new")
public class NewController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private INewService newService;
	
	@Inject
	private ICategoryServie categoryServie;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		NewModel model = FormUtil.toModel(NewModel.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem());
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()) );
			view = "/view/admin/new/list.jsp";
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId()!=null) {
				model = newService.findOne(model.getId());
			}
			request.setAttribute("categories", categoryServie.findAll());
			view = "/view/admin/new/edit.jsp";
		}
		MessageUtil.showMessage(request);
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
}
