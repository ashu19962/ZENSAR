package Com.Dao;
import java.util.List;
import Com.model.Restaurant;
	public interface RestaurantDao {
		int addRestaurant(Restaurant rs);
		List<Restaurant> getAllRestaurants();
	}




