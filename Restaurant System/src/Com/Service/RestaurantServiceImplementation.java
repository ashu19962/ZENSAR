package Com.Service;


import java.util.List;

import Com.Dao.RestaurantDao;
import Com.Dao.RestaurantDaoImplementation;
import Com.model.Restaurant;

public  class RestaurantServiceImplementation implements RestaurantService {
		
		RestaurantDao restauranDao;
		

		public RestaurantServiceImplementation() {
		//	super();
			restauranDao=new RestaurantDaoImplementation();
		}

		public RestaurantServiceImplementation(RestaurantDao restauranDao) {
			super();
			this.restauranDao = restauranDao;
		}

		public RestaurantDao getRestauranDao() {
			return restauranDao;
		}

		public void setRestauranDao(RestaurantDao restauranDao) {
			this.restauranDao = restauranDao;
		}

		

		@Override
		public int addRestaurant(Restaurant restaurant) {
			// TODO Auto-generated method stub
			return restauranDao.addRestaurant(restaurant);
		}

		@Override
		public List<Restaurant> getAllRestaurants() {
			// TODO Auto-generated method stub
			return restauranDao.getAllRestaurants();
		}
		 
	}

