import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main(){
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.teal
      ),
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  static const platform = const MethodChannel('message.send');
  String _message = "Nothing yet received";


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Native Interaction"),
      ),
      body: Container(
        child: Column(
          children: <Widget>[
            SizedBox(
              height: 20,
            ),
            Center(
              child:Text(_message),
            ),
            RaisedButton(
              onPressed: load,
              color: Colors.teal,
              child: Text("Load"),
            )
          ],
        ),
      ),
    );
  }

  void load() async{

    String str = await _getMessage();
    setState(() {
      _message = str;
    });
  }

  Future<String> _getMessage() async{
    String value;
    try{
      value = await platform.invokeMethod('getMessage');
    }catch(e){
      print(e);
    }
    return value;
  }
}


