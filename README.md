# ANPR-for-Smart-Parking

### How to use 

Detect LP from an image
````
python detector.py --image test.jpg

To train models run this command

`` $ python main.py -mode train -d dataset``

To recognize licence plate run this command

`` $ python main.py -mode predict -i test.jpg -model mlp.pkl``