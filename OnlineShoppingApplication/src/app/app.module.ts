import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { FooterComponent } from './Components/footer/footer.component';
import { UserLoginComponent } from './Components/Login/user-login/user-login.component';
import { AdminLoginComponent } from './Components/Login/admin-login/admin-login.component';
import { RetailerLoginComponent } from './Components/Login/retailer-login/retailer-login.component';
import { UserRegistrationComponent } from './Components/Register/user-registration/user-registration.component';
import { RetailerRegistrationComponent } from './Components/Register/retailer-registration/retailer-registration.component';
import { HomeComponent } from './Components/home/home.component';
import { CategoriesComponent } from './Components/categories/categories.component';
import { ProductsComponent } from './Components/products/products.component';
import { CartComponent } from './Components/cart/cart.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    UserLoginComponent,
    AdminLoginComponent,
    RetailerLoginComponent,
    UserRegistrationComponent,
    RetailerRegistrationComponent,
    HomeComponent,
    CategoriesComponent,
    ProductsComponent,
    CartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
