package Com.Cantroller;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Com.model.Restaurant;
import Com.Service.RestaurantService;
import Com.Service.RestaurantServiceImplementation;
	public class RController {
		public static void main(String[] args)
		{
		Scanner scanner=new Scanner(System.in);
		
		RestaurantService restaurantService= new RestaurantServiceImplementation(); 
			List<Restaurant> restaurantList=restaurantService.getAllRestaurants();
			Iterator<Restaurant> itr=restaurantList.iterator();
			
			System.out.println("**********   All  Restaurant Name ***************");
			while (itr.hasNext()) {
				Restaurant restaurant = (Restaurant) itr.next();
				//System.out.println("Enter Restaurant IDe:- "+ restaurant.());
				System.out.println( restaurant.getName());
				/*System.out.println(" Restaurant Otime:- "+ restaurant.getOtime());
				System.out.println(" Restaurant Ctime:- "+ restaurant.getCtime());
				System.out.println(" Restaurant phone:- "+ restaurant.getPhone());
				System.out.println("**************************************");*/	
			}
			System.out.println(" ");
			System.out.println("******* Enter  Restaurant information ************");
			System.out.println("Enter Restaurant Name:- ");
			String restaurantName=scanner.next();
			System.out.println("Enter Restaurant Out time:- ");
			int restaurantOtime=scanner.nextInt();
			System.out.println("Enter Restaurant Close time:- ");
			int restaurantCtime=scanner.nextInt();
			System.out.println("Enter Restaurant Phone:- ");
			int restaurantPhone=scanner.nextInt();
			String rsphone=String.valueOf(restaurantPhone);
			
			 if(!rsphone.matches("\\d{10}"))
	    	 {
	    		 System.out.println("Enter valid  mobile number" );
	    	 }
	   	
			System.out.println("Enter Restaurant Address:- ");
			String restaurantAddr=scanner.next();
			System.out.println("Enter Restaurant Cuisine:- ");
			String restaurantCuisine=scanner.next();
			
			
			Restaurant rs=new Restaurant(restaurantName,restaurantOtime,restaurantCtime,restaurantPhone,restaurantAddr,restaurantCuisine);
			
		    
		   {
		    	System.out.println("Restaurant added sucessfully.....");
		     
		    }
		    
		}
	}


