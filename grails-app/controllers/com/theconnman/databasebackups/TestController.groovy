package com.theconnman.databasebackups

class TestController {

    def create() {
		println 'Create controller'
		new Test(name: 'Test').save();
	}

    def update() {
		println 'Update controller'
		Test test = Test.list().first();
		test.name += '1';
		test.save();
	}

    def delete() {
		println 'Delete controller'
		Test.list().first().delete();
	}
}
