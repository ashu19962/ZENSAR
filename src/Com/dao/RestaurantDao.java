package Com.dao;
import java.util.List;

import Com.model.Restaurant;
	
	public interface RestaurantDao 
	{
		List<Restaurant> getAllRestaurants();
		
		int addRestaurant(Restaurant rs);
		
		int deleteRestaurant(String s);
		
		int updateRestaurant(Restaurant rs);
		
		Restaurant searchRestaurant(String rs);
	}
	