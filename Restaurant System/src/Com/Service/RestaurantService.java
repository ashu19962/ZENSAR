package Com.Service;
import java.util.List;
import Com.model.Restaurant;
	
	public interface RestaurantService {
		List<Restaurant> getAllRestaurants();
		int addRestaurant(Restaurant rs);

	}


