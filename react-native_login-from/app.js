/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Alert,Platform, StyleSheet, Text, View,Button,TextInput} from 'react-native';
import { GoogleSignin, GoogleSigninButton } from 'react-native-google-signin';
import firebase from 'firebase';






const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};




export default class App extends Component<Props> {
state = {email:'',password:'',error:''};
  onButtonPress()
  {
     const {email , password} = this.state;

     firebase.auth.signInWithEmailAndPassword(email,password).catch(() =>{
       firebase.auth.createUserWithEmailAndPassword(email,password).catch(() =>{

              this.setState({error:'Login failed! try to SignUp'});
       });
     });
  }


	componentWillMount()        {

     firebase.initializeApp(
	                    {
    apiKey: 'xxxxxxxxxxxxxxxxxxxxxx',
    authDomain: 'xxxxxxxxxxxxxxxxxxx',
    databaseURL: 'xxxxxxxxxxxx',
    projectId: 'xxxxxxxxxx',
    storageBucket: 'xxxxxxxxxx',
    messagingSenderId: 'xxxxxxxxxx'
                        }

	);}


  render() {
    return (
      <View style={styles.container}>
<View style={styles.Card}>
<Text>E-mail</Text>
<TextInput
            placeholder="user@gmail.com"
            autoCorrect={false}
            value={this.state.email}
            onChangeText={email => this.setState({email})}
            style={styles.CardSection}
/>
<Text>password</Text>

<TextInput
secureTextEntry
placeholder="password"
value={this.state.password}
onChangeText={password => this.setState({password})}
style={styles.CardSection}/>

<Text>{this.state.error}</Text>
<Button
onPress={this.onButtonPress.bind(this)}
  title="LOGIN"
  color="#4281a4"
  />
</View>
    </View>
    );

  }
  }



const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
        justifyContent:'center',

    backgroundColor: '#a288a6',
  },

  tracker: {
    fontSize: 40,
    textAlign: 'center',
    margin: 10,
  },
  Card: {
    alignItems: 'center',
    justifyContent:'center',
    backgroundColor: '#bb9bb0',
    height:300,
    width:350,
    shadowColor: 'black',
      shadowOffset: {
        width: 0,
        height: 3
      },
      shadowRadius: 5,
      shadowOpacity: 0.9,
      elevation: 7,

  },
  CardSection:{
    height:50 ,
     width:300,
   marginBottom:15,
   width:300,
   height:50,
   backgroundColor: '#f1e3e4',
   shadowColor: 'black',
     shadowOffset: {
       width: 0,
       height: 3
     },
     shadowRadius: 5,
     shadowOpacity: 0.8,
     elevation: 2,

}

});
