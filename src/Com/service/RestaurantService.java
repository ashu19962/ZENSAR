    package Com.service;
	import java.util.List;
    import Com.dao.RestaurantDao;
import Com.model.Restaurant;
	public interface RestaurantService {
		List<Restaurant> getAllRestaurants();
		int addRestaurant(Restaurant rs);
		int deleteRestaurant(String n);
		int updateRestaurant(Restaurant rs);
		Com.model.Restaurant  searchRestaurant(String rs);

	}

