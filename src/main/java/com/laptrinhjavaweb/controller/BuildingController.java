package com.laptrinhjavaweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.FromUtil;

@WebServlet(urlPatterns = {"/admin-building"})
public class BuildingController extends HttpServlet {
	
	private static final long serialVersionUID = 2686801510274002166L;
	
	private IBuildingService buildingService;
	
	public BuildingController() {
		if(buildingService==null) {
		buildingService = new BuildingService();
	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuildingDTO model = FromUtil.toModel(BuildingDTO.class, request);
		String url ="";
		if(request.getParameter("action").equals("LIST")) {
			url = "/views/building/list.jsp";
			BuildingSearchBuilder builder = initBuildingBuilder(model);
			Pageble pageble = new PageRequest(null, null, null);
			
			model.setListResults(buildingService.findAll(builder, pageble));
		}
		else if(request.getParameter("action").equals("EDIT")) {
			url = "/views/building/edit.jsp";
		}
		
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	
	private BuildingSearchBuilder initBuildingBuilder(BuildingDTO model) {
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(model.getName()).setWard(model.getWard()).setStreet(model.getStreet())
				.setNumberOfBasement(model.getNumberOfBasement()).setAreaRentFrom(model.getAreaRentFrom())
				.setAreaRentTo(model.getAreaRentTo()).setCostRentFrom(model.getCostRentFrom()).setCostRentTo(model.getCostRentTo())
				.setBuildingTypes(model.getBuildingTypes()).build();
		return builder;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
