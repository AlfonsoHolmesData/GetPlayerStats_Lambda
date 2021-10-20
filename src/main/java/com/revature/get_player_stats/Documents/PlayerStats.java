package com.revature.get_player_stats.Documents;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@Data
@DynamoDbBean
public class PlayerStats {

    String id;
    String role;
    int points;
    boolean won;
    String owning_user_username;
    String owning_user_id;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getRank() {
        return id;
    }

    public void setRank(String id) {
        this.id = id;
    }
    @DynamoDbAttribute("role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @DynamoDbAttribute("points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    @DynamoDbAttribute("won")
    public boolean isWin() {
        return won;
    }

    public void setWin(boolean won) {
        this.won = won;
    }
    @DynamoDbAttribute("owning_user_username")
    public String getOwning_user_username() {
        return owning_user_username;
    }

    public void setOwning_user_username(String owning_user_username) {
        this.owning_user_username = owning_user_username;
    }
    @DynamoDbAttribute("owning_user_id")
    public String getOwning_user_id() {
        return owning_user_id;
    }

    public void setOwning_user_id(String owning_user_id) {
        this.owning_user_id = owning_user_id;
    }
}
