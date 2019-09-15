package com.jwt.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.divvy.beans.StationStatistics;
import com.divvy.services.DivvyService;

@Path("/")
public class DivvyResource {
  
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stats/{stationname}")
    public Response getStats(@PathParam("stationname") String stationname) {
    	  
        DivvyService divvyService = new DivvyService();
        StationStatistics stats = divvyService.getStatistics(stationname);
        return Response.status(200).entity(stats).type(MediaType.APPLICATION_JSON).build();
  
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("revenue/top")
    public Response getTopRevenue() {
    	  
        DivvyService divvyService = new DivvyService();
        List<String> topRevenueStations = divvyService.getTopRevenueStations();
        return Response.status(200).entity(topRevenueStations).type(MediaType.APPLICATION_JSON).build();
  
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("bikes/to_service")
    public Response getBikesToService() {
    	  
        DivvyService divvyService = new DivvyService();
        List<Integer> bikeIdsToService = divvyService.getBikesToService();
        return Response.status(200).entity(bikeIdsToService).type(MediaType.APPLICATION_JSON).build();
  
    }
}
  
