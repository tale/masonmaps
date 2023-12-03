import React from 'react';
import {useEffect, useState} from 'react';


const [hello, sethello] = useState("");
  useEffect(() =>{
    fetch(".api/hello")
    .then(response=>response.text())
    .then(data=>sethello(data));
  },[])
  