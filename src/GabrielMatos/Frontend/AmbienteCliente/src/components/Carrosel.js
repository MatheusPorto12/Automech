import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Carousel from 'react-bootstrap/Carousel';

export default function Carrosel() {
  return (
    <div style={{ display: 'block' }}>
      <Carousel className="w-100">
        <Carousel.Item interval={6000}>
          <img className="d-block w-100"
src='https://blog.simplusbr.com/wp-content/uploads/2020/09/oficina-mecanica-organizada.jpg'/>
          <Carousel.Caption>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item interval={500}>
          <img
            className="d-block w-100"
src="https://media.geeksforgeeks.org/wp-content/uploads/20210425122716/1-300x115.png"/>
          <Carousel.Caption>
            <h3>Label for second slide</h3>
            <p>Sample Text for Image Two</p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    </div>
  );
}