from flask import Flask, jsonify
from flask_restplus import Resource, Api, fields


app = Flask(__name__)
api = Api(app, version='1.0', title='Country CRUD API',
    description='A simple Country API',
)

country = api.model('Country', {
    'id': fields.Integer(readOnly=True, description='The country unique identifier'),
    'name': fields.String(required=True, description='The country name'),
    'continent': fields.String(required=True, description='The country continent')
})
class CrudCountry(object):
    def __init__(self):
        self.counter = 0
        self.countries = []

    def get(self, id):
        for country in self.countries:
            if country['id'] == id:
                return country
        api.abort(404, "Country {} doesn't exist".format(id))

    def create(self, data):
        country = data
        country['id'] = self.counter = self.counter + 1
        self.countries.append(country)
        return country

    def update(self, id, data):
        country = self.get(id)
        country.update(data)
        return country

    def delete(self, id):
        country = self.get(id)
        self.countries.remove(country)

crud = CrudCountry()
crud.create({'name': 'Senegal', 'continent' : 'Africa'})
crud.create({'name': 'China','continent' : 'Asia'})
crud.create({'name': 'German','continent' : 'Europa'})

@api.route('/countries')
class CountryListResource(Resource):
    def get(self):
        return jsonify(crud.countries)
    @api.expect(country)
    def post(self):
        '''Create a new Country'''
        return crud.create(api.payload), 201

@api.route('/countries/<int:id>')
class CountryResource(Resource):
    def get(self, id):
        return jsonify(crud.get(id))
    @api.response(204, 'Country deleted')
    def delete(self, id):
        '''Delete a task given its identifier'''
        crud.delete(id)
        return '', 204
    @api.expect(country)
    def put(self, id):
        '''Update a country given its identifier'''
        return crud.update(id, api.payload)
   
if __name__ == '__main__':
    app.run(debug=True)