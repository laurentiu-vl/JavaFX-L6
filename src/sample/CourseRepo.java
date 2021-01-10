package sample;

import java.util.List;

class CourseRepo implements ICrudRepository
{
    private List<Course> Courses;

    public CourseRepo(List<Course> cursuri) {
        this.Courses = cursuri;
    }

    public List<Course> getCourses()
    {
        return Courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.Courses = courses;
    }

    @Override
    public Object findOne(int id)
    {
        if(id> Courses.size()-1 || id<0)
        {
            return null;
        }
        else
        {
            return Courses.get(id);
        }
    }

    @Override
    public Iterable findAll() {
        return Courses;
    }

    @Override
    public Object save(Object entity)
    {
        for(int i = 0; i< Courses.size(); i++)
        {
            if(Courses.get(i) == entity)
            {
                return entity;
            }
        }
        Courses.add((Course) entity);
        return null;
    }

    @Override
    public Object delete(int id)
    {
        if(id>=0 && id< Courses.size() - 1)
        {
            Course aux= Courses.get(id);
            Courses.remove(id);
            return aux;
        }
        return null;
    }

    @Override
    public Object update(Object entity, Object newentity)
    {
        for(int i = 0; i< Courses.size(); i++)
        {
            if(Courses.get(i) == entity)
            {
                Courses.set(i, (Course) newentity);
                return null;
            }
        }
        return entity;
    }
}



