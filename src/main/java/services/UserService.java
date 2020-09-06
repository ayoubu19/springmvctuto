package services;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
        private List<User> collborattors = new ArrayList<>(List.of(

                        new User(1, "elbouzaidi", "mohammed", "mohammed", "1234567", "pilote", 27, -26),

                        new User(2, "elbouzaidi", "amine", "amine", "1234567", "ied", 27, 12),

                        new User(3, "elbouzaidi", "imad", "imad", "1234567", "ied", 27, 3),

                        new User(4, "elbouzaidi", "ayoub", "ayoub", "1234567", "ied", 27, 13)

        ));

        public UserService() {
        }

        public void setCollborattors(List<User> collborattors) {
                this.collborattors = collborattors;
        }

    public Boolean isUserValid(String username, String password) {
        return this.collborattors
                .stream()
                .anyMatch(user -> username.equals(user.getUsername()) && password.equals(user.getPassword()));
                
    }

        public User getUserByUsername(String username) {
                return this.collborattors.stream().filter(user -> username.equals(user.getUsername())).findFirst()
                                .get();
        }

        public List<User> getCollborattors(String username) {
                return this.collborattors.stream().filter(user -> !username.equals(user.getUsername()))
                                .collect(Collectors.toList());
        }

        public void deletColaborator(Long collaboratorId) {
                User wanteduser = this.collborattors.stream().filter(user -> collaboratorId.equals(user.getId()))
                                .findFirst().get();
                this.collborattors.remove(wanteduser);
        }

        public void addCollaborateur(User collaborator) {
                this.collborattors.add(collaborator);
        }
}
