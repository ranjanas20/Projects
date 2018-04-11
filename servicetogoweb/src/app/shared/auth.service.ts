import {Subject} from 'rxjs/Subject'
export class AuthService{
    loggedin: Subject<boolean> = new Subject();
    signup(username: String, password: string, email: String){

    } 
    login(username: string, password: string){

        this.loggedin.next(true);
    }  
    logout(){
        this.loggedin.next(false);
    } 
}