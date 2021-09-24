package Com.service;
	import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
	import Com.dao.RestaurantDao;
	import Com.dao.RestaurantDaoImplementation;
	import Com.model.Restaurant;
	
	
	public class RestaurantServiceImplementation implements RestaurantService {
		
		RestaurantDao  restauranDao;
		Connection con = null ;
		
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
		public List<Restaurant> getAllRestaurants() {
			// TODO Auto-generated method stub
			return restauranDao.getAllRestaurants();
		}

		

		@Override
		public int deleteRestaurant(String n) {
			// TODO Auto-generated method stub
			return restauranDao.deleteRestaurant(n);
		}

		@Override
		public int updateRestaurant(Restaurant rs) {
			// TODO Auto-generated method stub
			return restauranDao.updateRestaurant(rs);
		}

		@Override
		public  Restaurant searchRestaurant(String rs) {
			// TODO Auto-generated method stub
			return restauranDao.searchRestaurant(rs);
		}

		@Override
		public int addRestaurant(Restaurant rs) {
			
			return restauranDao.addRestaurant(rs);
		}

		
		 
	}
