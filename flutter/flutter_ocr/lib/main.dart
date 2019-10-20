import 'dart:io';
import 'package:image_picker/image_picker.dart';
import 'package:flutter/material.dart';
import 'package:firebase_ml_vision/firebase_ml_vision.dart';

void main(){
  runApp(new MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  File file;
  bool loaded = false;
  var text="";
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("OCR"),
        ),
        body: Column(
          children: <Widget>[

            loaded?Center(
              child: Container(
                width: 200,
                height: 200,
                decoration: BoxDecoration(
                  image: DecorationImage(
                      image: FileImage(file),
                      fit: BoxFit.cover
                  )
                ),
              ),
            ):Container(),
            RaisedButton(
              child: Text("Pick Image"),
              onPressed: pickImage,
            ),
            SizedBox(
              height: 10,
            ),
            RaisedButton(
              child: Text("Read text"),
              onPressed: readText,
            ),
            Text(text),
          ],
        ),
      ),
    );
  }

  Future pickImage() async{
    var tempStore = await ImagePicker.pickImage(source: ImageSource.gallery);
    setState(() {
      file = tempStore;
      loaded = true;
    });
  }

  Future readText() async{
    FirebaseVisionImage image = FirebaseVisionImage.fromFile(file);
    TextRecognizer tr = FirebaseVision.instance.textRecognizer();
    VisionText vt = await tr.processImage(image);

    for(TextBlock tb in vt.blocks){
      setState(() {
        text = tb.text;
      });
    }
  }
}

