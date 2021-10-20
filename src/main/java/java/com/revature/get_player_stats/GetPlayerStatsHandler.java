package java.com.revature.get_player_stats;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class GetPlayerStatsHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final UserRepository userRepo;
    private static final Gson mapper = new GsonBuilder().setPrettyPrinting().create();

    public GetPlayerStatsHandler() {
        this.userRepo = new UserRepository();
    }

    public GetPlayerStatsHandler( UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {

        LambdaLogger logger = context.getLogger();
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        try{
            List<User> all_users = userRepo.getAllUsers();
            response.setBody(mapper.toJson(all_users));
            response.setStatusCode(200);
        }catch(Exception e){
            response.setBody(e.getMessage());
            response.setStatusCode(400);
        }
        return response;
    }
}
