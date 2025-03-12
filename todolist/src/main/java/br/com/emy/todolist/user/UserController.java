package br.com.emy.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * modificadores
 * public
 * private
 * protected
 */
@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;
    /**
     * String (texto)
     * Integer (int)
     * double (double) numeros 0.00
     * float (float) numeros 0.000
     * char (A C)
     * Date (data)
     * void
     */

     /*
      * Body
      */
      @PostMapping("/")
      public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUserName(userModel.getUserName());
        if(user!=null){
          System.out.println("Usuario já existe");
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario ja existe");
        }

        var passwordHasred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHasred);
        
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
      
      }}
